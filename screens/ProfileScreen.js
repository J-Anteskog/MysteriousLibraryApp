// screens/ProfileScreen.js
import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Alert, TextInput, ActivityIndicator } from 'react-native';
import { Picker } from '@react-native-picker/picker';
import { translate } from '../utils/i18n';

// Importera Supabase-klienten direkt
import { supabase } from '../supabaseClient'; 

export default function ProfileScreen() {
    const [user, setUser] = useState(null);
    const [profile, setProfile] = useState({
        name: '',
        age: '',
        zodiac: '',
        favoriteCategory: '',
        favoriteCardOrRune: '',
    });
    const [loading, setLoading] = useState(false);
    const [saving, setSaving] = useState(false);

    useEffect(() => {
        const fetchUserAndProfile = async () => {
            setLoading(true);
            const { data: { user } } = await supabase.auth.getUser();
            setUser(user);
            if (user) {
                // Hämta profil från Supabase
                const { data, error } = await supabase
                    .from('profiles')
                    .select('*')
                    .eq('id', user.id)
                    .single();
                if (data) {
                    setProfile({
                        name: data.name || '',
                        age: data.age ? String(data.age) : '',
                        zodiac: data.zodiac || '',
                        favoriteCategory: data.favorite_category || '',
                        favoriteCardOrRune: data.favorite_card_or_rune || '',
                    });
                }
            }
            setLoading(false);
        };
        fetchUserAndProfile();
    }, []);

    const handleLogout = async () => {
        try {
            const { error } = await supabase.auth.signOut();
            if (error) {
                throw error;
            }
        } catch (error) {
            Alert.alert("Logout error", error.message);
        }
    };

    const handleSave = async () => {
        if (!user) return;
        setSaving(true);
        const updates = {
            id: user.id,
            name: profile.name,
            age: profile.age ? parseInt(profile.age) : null,
            zodiac: profile.zodiac,
            favorite_category: profile.favoriteCategory,
            favorite_card_or_rune: profile.favoriteCardOrRune,
            updated_at: new Date(),
        };
        const { error } = await supabase.from('profiles').upsert(updates, { onConflict: ['id'] });
        setSaving(false);
        if (error) {
            Alert.alert('Save error', error.message);
        } else {
            Alert.alert('Profile saved', 'Your profile has been updated!');
        }
    };

    if (loading) {
        return (
            <View style={styles.container}><ActivityIndicator size="large" color="#e0c097" /></View>
        );
    }

    return (
        <View style={styles.container}>
            <Text style={styles.title}>{translate('profile_title')}</Text>
            {user && (
                <View style={styles.infoBox}>
                    <Text style={styles.emailText}>{translate('profile_logged_in_as')}</Text>
                    <Text style={styles.emailText}>{user.email}</Text>
                </View>
            )}
            <TextInput
                style={styles.input}
                placeholder={translate('profile_name')}
                value={profile.name}
                onChangeText={text => setProfile({ ...profile, name: text })}
                placeholderTextColor="#888"
            />
            <TextInput
                style={styles.input}
                placeholder={translate('profile_age')}
                value={profile.age}
                onChangeText={text => setProfile({ ...profile, age: text.replace(/[^0-9]/g, '') })}
                keyboardType="numeric"
                placeholderTextColor="#888"
            />
            <TextInput
                style={styles.input}
                placeholder={translate('profile_zodiac')}
                value={profile.zodiac}
                onChangeText={text => setProfile({ ...profile, zodiac: text })}
                placeholderTextColor="#888"
            />
            <Text style={styles.label}>{translate('profile_favorite_category')}</Text>
            <View style={styles.pickerWrapper}>
                <Picker
                    selectedValue={profile.favoriteCategory}
                    style={styles.picker}
                    onValueChange={itemValue => setProfile({ ...profile, favoriteCategory: itemValue })}
                    dropdownIconColor="#e0c097"
                >
                    <Picker.Item label={translate('profile_select')} value="" />
                    <Picker.Item label={translate('profile_tarot')} value="tarot" />
                    <Picker.Item label={translate('profile_runes')} value="runes" />
                    <Picker.Item label={translate('profile_oracle')} value="oracle" />
                </Picker>
            </View>
            <TextInput
                style={styles.input}
                placeholder={translate('profile_favorite_card_or_rune')}
                value={profile.favoriteCardOrRune}
                onChangeText={text => setProfile({ ...profile, favoriteCardOrRune: text })}
                placeholderTextColor="#888"
            />
            <TouchableOpacity style={styles.button} onPress={handleSave} disabled={saving}>
                <Text style={styles.buttonText}>{saving ? translate('profile_saving') : translate('profile_save')}</Text>
            </TouchableOpacity>
            <TouchableOpacity style={[styles.button, styles.logoutButton]} onPress={handleLogout}>
                <Text style={styles.buttonText}>{translate('profile_logout')}</Text>
            </TouchableOpacity>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#1a1a2e',
        padding: 20,
    },
    title: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#e0c097',
        marginBottom: 20,
    },
    emailText: {
        fontSize: 16,
        color: '#e0c097',
        marginBottom: 10,
    },
    input: {
        backgroundColor: '#343a40',
        color: '#e0c097',
        borderRadius: 8,
        padding: 10,
        marginBottom: 15,
        width: 250,
    },
    label: {
        color: '#e0c097',
        fontSize: 16,
        marginBottom: 5,
        marginTop: 10,
    },
    button: {
        backgroundColor: '#e0c097',
        paddingVertical: 15,
        paddingHorizontal: 40,
        borderRadius: 10,
        marginBottom: 10,
        width: 250,
        alignItems: 'center',
        marginTop: 10,
    },
    logoutButton: {
        backgroundColor: '#5f6c7c',
    },
    infoBox: {
        backgroundColor: '#22223b',
        borderRadius: 10,
        padding: 10,
        marginBottom: 15,
        alignItems: 'center',
        width: 250,
    },
    pickerWrapper: {
        backgroundColor: '#343a40',
        borderRadius: 8,
        marginBottom: 15,
        width: 250,
        overflow: 'hidden',
    },
    picker: {
        color: '#e0c097',
        width: '100%',
        height: 44,
    },
    buttonText: {
        color: '#1a1a2e',
        fontSize: 20,
        fontWeight: 'bold',
    },
});