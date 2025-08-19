// screens/DiaryScreen.js
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, FlatList, TextInput, TouchableOpacity, Image, Alert, ActivityIndicator } from 'react-native';

// Importera Supabase-klienten från din konfigurationsfil
import { supabase } from '../supabaseClient';

// Importera expo-image-picker (som du redan har)
import * as ImagePicker from 'expo-image-picker';
import 'react-native-get-random-values';
import { v4 as uuidv4 } from 'uuid';
import * as FileSystem from 'expo-file-system';

// Polyfill: base64 till Blob
function base64ToBlob(base64, contentType = '', sliceSize = 512) {
    const byteCharacters = atob(base64);
    const byteArrays = [];
    for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
        const slice = byteCharacters.slice(offset, offset + sliceSize);
        const byteNumbers = new Array(slice.length);
        for (let i = 0; i < slice.length; i++) {
            byteNumbers[i] = slice.charCodeAt(i);
        }
        const byteArray = new Uint8Array(byteNumbers);
        byteArrays.push(byteArray);
    }
    return new Blob(byteArrays, { type: contentType });
}

export default function DiaryScreen() {
    const [diaryEntries, setDiaryEntries] = useState([]);
    const [newEntry, setNewEntry] = useState('');
    const [imageUri, setImageUri] = useState(null);
    const [loading, setLoading] = useState(false);
    const [user, setUser] = useState(null);

    // Hämta användaren från Supabase-sessionen
    useEffect(() => {
        const fetchUser = async () => {
            const { data: { user } } = await supabase.auth.getUser();
            setUser(user);
        };
        fetchUser();
    }, []);

    // Realtidsuppdateringar med Supabase v2 channel-API
    useEffect(() => {
        if (!user) return;

        const channel = supabase.channel('diary_entries_changes')
            .on(
                'postgres_changes',
                {
                    event: 'INSERT',
                    schema: 'public',
                    table: 'diary_entries',
                    filter: `user_id=eq.${user.id}`
                },
                payload => {
                    setDiaryEntries(currentEntries => [payload.new, ...currentEntries]);
                }
            )
            .on(
                'postgres_changes',
                {
                    event: 'DELETE',
                    schema: 'public',
                    table: 'diary_entries',
                    filter: `user_id=eq.${user.id}`
                },
                payload => {
                    setDiaryEntries(currentEntries => currentEntries.filter(entry => entry.id !== payload.old.id));
                }
            )
            .subscribe();

        return () => {
            supabase.removeChannel(channel);
        };
    }, [user]);

    // Hämta befintliga dagboksinlägg från Supabase
    useEffect(() => {
        if (!user) return;

        const fetchEntries = async () => {
            const { data: entries, error } = await supabase
                .from('diary_entries')
                .select('*')
                .eq('user_id', user.id)
                .order('created_at', { ascending: false });

            if (error) {
                console.error('Kunde inte ladda inlägg:', error.message);
                Alert.alert('Fel', 'Kunde inte ladda dagboksinlägg.');
            } else {
                setDiaryEntries(entries);
            }
        };

        fetchEntries();
    }, [user]);

    // Funktion för att välja en bild från galleriet
    const pickImage = async () => {
        const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
        if (status !== 'granted') {
            Alert.alert('Behörighet krävs', 'Du måste ge appen tillgång till bilder för att kunna välja en bild.');
            return;
        }
        let result = await ImagePicker.launchImageLibraryAsync({
            mediaTypes: ImagePicker.MediaTypeOptions.Images,
            allowsEditing: true,
            aspect: [4, 3],
            quality: 0.5,
        });

        if (!result.canceled) {
            setImageUri(result.assets[0].uri);
        }
    };

    // Funktion för att ladda upp bilden till Supabase Storage
    const uploadImage = async (uri) => {
        console.log('Försöker ladda upp bild. URI:', uri);
        const fileExt = uri.split('.').pop();
        const fileName = `${uuidv4()}.${fileExt}`;
        const filePath = `${user.id}/${fileName}`;

        let fileData;
        try {
            fileData = await FileSystem.readAsStringAsync(uri, {
                encoding: FileSystem.EncodingType.Base64,
            });
        } catch (fsErr) {
            console.log('Fel vid FileSystem.readAsStringAsync:', fsErr);
            throw new Error('Kunde inte läsa bildfilen: ' + fsErr.message);
        }

        const contentType = fileExt === 'png' ? 'image/png' : 'image/jpeg';

        const { error: uploadError } = await supabase.storage
            .from('diary_images')
            .upload(filePath, fileData, {
                contentType,
                cacheControl: '3600',
                upsert: false
            });

        if (uploadError) {
            console.log('Supabase upload error:', uploadError);
            throw new Error(uploadError.message);
        }

        const { data } = supabase.storage.from('diary_images').getPublicUrl(filePath);
        console.log('Bild uppladdad! Public URL:', data.publicUrl);
        return data.publicUrl;
    };

    // Funktion för att spara inlägget i Supabase
    const saveEntry = async () => {
        if (newEntry.trim() === '') {
            Alert.alert("Fel", "Dagboksinlägget kan inte vara tomt.");
            return;
        }

        setLoading(true);
        let imageUrl = null;

        try {
            if (imageUri) {
                imageUrl = await uploadImage(imageUri);
            }

            const { data, error: insertError } = await supabase
                .from('diary_entries')
                .insert([
                    {
                        text: newEntry,
                        image_url: imageUrl,
                        user_id: user.id
                    }
                ])
                .select();

            if (insertError) {
                throw new Error(insertError.message);
            }

            // Lägg till det nya inlägget direkt i listan
            if (data && data[0]) {
                setDiaryEntries(current => [data[0], ...current]);
            }

            setNewEntry('');
            setImageUri(null);
        } catch (e) {
            Alert.alert("Fel", "Kunde inte spara inlägget: " + e.message);
        } finally {
            setLoading(false);
        }
    };

    // Funktion för att uppdatera ett inlägg
    const updateEntry = async (id, newText) => {
        setLoading(true);
        try {
            const { data, error } = await supabase
                .from('diary_entries')
                .update({ text: newText })
                .eq('id', id)
                .eq('user_id', user.id)
                .select();
            if (error) throw new Error(error.message);
            // Uppdatera listan direkt
            if (data && data[0]) {
                setDiaryEntries(current => current.map(entry => entry.id === id ? { ...entry, ...data[0] } : entry));
            }
        } catch (e) {
            Alert.alert('Fel', 'Kunde inte uppdatera inlägget: ' + e.message);
        } finally {
            setLoading(false);
        }
    };

    // Funktion för att radera ett inlägg
    const deleteEntry = async (id) => {
        Alert.alert(
            'Radera inlägg',
            'Är du säker på att du vill radera detta inlägg?',
            [
                { text: 'Avbryt', style: 'cancel' },
                {
                    text: 'Radera', style: 'destructive', onPress: async () => {
                        setLoading(true);
                        try {
                            const { error } = await supabase
                                .from('diary_entries')
                                .delete()
                                .eq('id', id)
                                .eq('user_id', user.id);
                            if (error) throw new Error(error.message);
                            // Ta bort inlägget direkt ur listan
                            setDiaryEntries(current => current.filter(entry => entry.id !== id));
                        } catch (e) {
                            Alert.alert('Fel', 'Kunde inte radera inlägget: ' + e.message);
                        } finally {
                            setLoading(false);
                        }
                    }
                }
            ]
        );
    };

    // Redigeringsläge för inlägg
    const [editingId, setEditingId] = useState(null);
    const [editingText, setEditingText] = useState('');

    const renderItem = ({ item }) => (
        <View style={styles.entryContainer}>
            {editingId === item.id ? (
                <>
                    <TextInput
                        style={styles.textInput}
                        value={editingText}
                        onChangeText={setEditingText}
                        multiline
                    />
                    <View style={styles.buttonRow}>
                        <TouchableOpacity
                            style={styles.imageButton}
                            onPress={() => { setEditingId(null); setEditingText(''); }}
                        >
                            <Text style={styles.buttonText}>Avbryt</Text>
                        </TouchableOpacity>
                        <TouchableOpacity
                            style={styles.saveButton}
                            onPress={async () => {
                                await updateEntry(item.id, editingText);
                                setEditingId(null);
                                setEditingText('');
                            }}
                        >
                            <Text style={styles.buttonText}>Spara</Text>
                        </TouchableOpacity>
                    </View>
                </>
            ) : (
                <>
                    <Text style={styles.entryText}>{item.text}</Text>
                    {item.image_url && (
                        <Image source={{ uri: item.image_url }} style={styles.entryImage} />
                    )}
                    <Text style={styles.timestamp}>
                        {item.created_at ? new Date(item.created_at).toLocaleString() : 'Saving...'}
                    </Text>
                    <View style={styles.buttonRow}>
                        <TouchableOpacity
                            style={styles.imageButton}
                            onPress={() => { setEditingId(item.id); setEditingText(item.text); }}
                        >
                            <Text style={styles.buttonText}>Uppdatera</Text>
                        </TouchableOpacity>
                        <TouchableOpacity
                            style={styles.saveButton}
                            onPress={() => deleteEntry(item.id)}
                        >
                            <Text style={styles.buttonText}>Radera</Text>
                        </TouchableOpacity>
                    </View>
                </>
            )}
        </View>
    );

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Min Dagbok</Text>
            
            {loading && <ActivityIndicator size="large" color="#e0c097" />}

            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.textInput}
                    placeholder="Skriv ditt dagboksinlägg här..."
                    placeholderTextColor="gray"
                    multiline
                    value={newEntry}
                    onChangeText={setNewEntry}
                />
                {imageUri && (
                    <Image source={{ uri: imageUri }} style={styles.selectedImage} />
                )}
                <View style={styles.buttonRow}>
                    <TouchableOpacity style={styles.imageButton} onPress={pickImage}>
                        <Text style={styles.buttonText}>Välj Bild</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.saveButton} onPress={saveEntry} disabled={loading}>
                        <Text style={styles.buttonText}>Spara inlägg</Text>
                    </TouchableOpacity>
                </View>
            </View>

            <FlatList
                data={diaryEntries}
                renderItem={renderItem}
                keyExtractor={item => item.id}
                style={styles.list}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: { flex: 1, backgroundColor: '#1a1a2e', padding: 20 },
    title: { fontSize: 24, fontWeight: 'bold', color: '#e0c097', marginBottom: 20, textAlign: 'center' },
    inputContainer: { marginBottom: 20, backgroundColor: '#343a40', borderRadius: 10, padding: 15 },
    textInput: { color: 'white', height: 100, marginBottom: 10, paddingHorizontal: 10, borderColor: 'gray', borderWidth: 1, borderRadius: 5 },
    selectedImage: { width: '100%', height: 200, resizeMode: 'cover', borderRadius: 5, marginBottom: 10 },
    buttonRow: { flexDirection: 'row', justifyContent: 'space-between' },
    imageButton: { backgroundColor: '#5f6c7c', padding: 10, borderRadius: 5, flex: 1, marginRight: 5, alignItems: 'center' },
    saveButton: { backgroundColor: '#e0c097', padding: 10, borderRadius: 5, flex: 1, marginLeft: 5, alignItems: 'center' },
    buttonText: { color: '#1a1a2e', fontWeight: 'bold' },
    list: { flex: 1 },
    entryContainer: { padding: 15, backgroundColor: '#2d333b', borderRadius: 10, marginBottom: 15 },
    entryText: { color: 'white', fontSize: 16, marginBottom: 10 },
    entryImage: { width: '100%', height: 200, resizeMode: 'cover', borderRadius: 5, marginTop: 10 },
    timestamp: { color: 'gray', fontSize: 12, marginTop: 5, textAlign: 'right' },
});