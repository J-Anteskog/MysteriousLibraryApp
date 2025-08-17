// screens/ProfileScreen.js
import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Alert } from 'react-native';

// Importera Supabase-klienten direkt
import { supabase } from '../supabaseClient'; 

export default function ProfileScreen() {
    // Vi behöver inte useNavigation() eller navigation-objektet för utloggning
    // eftersom App.js hanterar navigeringen automatiskt via onAuthStateChange.

    const handleLogout = async () => {
        try {
            const { error } = await supabase.auth.signOut();
            if (error) {
                throw error;
            }
        } catch (error) {
            Alert.alert("Utloggningsfel", error.message);
        }
    };


    // Hämta användaren enligt Supabase v2 API
    const [user, setUser] = useState(null);
    useEffect(() => {
        const fetchUser = async () => {
            const { data: { user } } = await supabase.auth.getUser();
            setUser(user);
        };
        fetchUser();
    }, []);

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Min Profil</Text>
            {user && (
                <View>
                    <Text style={styles.emailText}>Inloggad som:</Text>
                    <Text style={styles.emailText}>{user.email}</Text>
                </View>
            )}
            
            <TouchableOpacity style={styles.button} onPress={handleLogout}>
                <Text style={styles.buttonText}>Logga ut</Text>
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
    button: {
        backgroundColor: '#e0c097',
        paddingVertical: 15,
        paddingHorizontal: 40,
        borderRadius: 10,
        marginBottom: 15,
        width: '80%',
        alignItems: 'center',
        marginTop: 20,
    },
    buttonText: {
        color: '#1a1a2e',
        fontSize: 20,
        fontWeight: 'bold',
    },
});