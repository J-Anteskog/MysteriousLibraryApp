// screens/ProfileScreen.js
import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Alert } from 'react-native';
import { signOut } from 'firebase/auth'; 
import { useNavigation } from '@react-navigation/native';
import { auth } from '../App'; // <-- Importera auth-instansen korrekt härifrån

export default function ProfileScreen() {
    const navigation = useNavigation();

    const handleLogout = async () => {
        try {
            await signOut(auth);
            // Ingen navigering behövs här, då onAuthStateChanged i App.js
            // kommer att upptäcka utloggningen och navigera automatiskt.
        } catch (error) {
            Alert.alert("Utloggningsfel", error.message);
        }
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Min Profil</Text>
            {auth.currentUser && (
                <View>
                    <Text style={styles.emailText}>Inloggad som:</Text>
                    <Text style={styles.emailText}>{auth.currentUser.email}</Text>
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