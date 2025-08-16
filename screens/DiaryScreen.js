// screens/DiaryScreen.js
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, FlatList, TextInput, TouchableOpacity, Image, Alert, ActivityIndicator } from 'react-native';
import { db, storage, auth } from '../App'; // Importera din Firebase-konfiguration
import { collection, addDoc, query, orderBy, onSnapshot, serverTimestamp } from 'firebase/firestore';
import { ref, uploadBytes, getDownloadURL } from 'firebase/storage';
import * as ImagePicker from 'expo-image-picker';
import 'react-native-get-random-values';
import { v4 as uuidv4 } from 'uuid';

export default function DiaryScreen() {
    const [diaryEntries, setDiaryEntries] = useState([]);
    const [newEntry, setNewEntry] = useState('');
    const [imageUri, setImageUri] = useState(null);
    const [loading, setLoading] = useState(false);
    const userId = auth.currentUser.uid;

    // Lyssnar på uppdateringar från Firestore i realtid
    useEffect(() => {
        const q = query(
            collection(db, `users/${userId}/diaryEntries`),
            orderBy('createdAt', 'desc')
        );

        const unsubscribe = onSnapshot(q, (querySnapshot) => {
            const entries = [];
            querySnapshot.forEach((doc) => {
                entries.push({ id: doc.id, ...doc.data() });
            });
            setDiaryEntries(entries);
        });

        return () => unsubscribe();
    }, [userId]);

    // Funktion för att välja en bild från galleriet
    const pickImage = async () => {
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

    // Funktion för att ladda upp bilden till Firebase Storage
    const uploadImage = async (uri) => {
        const response = await fetch(uri);
        const blob = await response.blob();
        const filename = `${uuidv4()}.jpg`;
        const storageRef = ref(storage, `images/${userId}/${filename}`);
        await uploadBytes(storageRef, blob);
        return await getDownloadURL(storageRef);
    };

    // Funktion för att spara inlägget i Firestore
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

            await addDoc(collection(db, `users/${userId}/diaryEntries`), {
                text: newEntry,
                imageUrl: imageUrl,
                createdAt: serverTimestamp(),
            });

            setNewEntry('');
            setImageUri(null);
        } catch (e) {
            Alert.alert("Fel", "Kunde inte spara inlägget: " + e.message);
        } finally {
            setLoading(false);
        }
    };

    const renderItem = ({ item }) => (
        <View style={styles.entryContainer}>
            <Text style={styles.entryText}>{item.text}</Text>
            {item.imageUrl && (
                <Image source={{ uri: item.imageUrl }} style={styles.entryImage} />
            )}
            <Text style={styles.timestamp}>
                {item.createdAt ? new Date(item.createdAt.toDate()).toLocaleString() : 'Saving...'}
            </Text>
        </View>
    );

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Min Dagbok</Text>

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
                        {loading ? (
                            <ActivityIndicator color="#1a1a2e" />
                        ) : (
                            <Text style={styles.buttonText}>Spara inlägg</Text>
                        )}
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