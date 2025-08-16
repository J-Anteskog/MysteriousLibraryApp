import React, { useState } from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity, ActivityIndicator, Alert } from 'react-native';

// Importera den nya Supabase-klienten
import { supabase } from '../supabaseClient';

export default function LoginScreen({ navigation }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [isLogin, setIsLogin] = useState(true);

    const handleLogin = async () => {
        setLoading(true);
        try {
            // Använd Supabase-metoden för inloggning
            const { error } = await supabase.auth.signInWithPassword({
                email,
                password,
            });
            if (error) {
                throw error;
            }
        } catch (error) {
            Alert.alert('Inloggningsfel', error.message);
        } finally {
            setLoading(false);
        }
    };

    const handleSignUp = async () => {
        setLoading(true);
        try {
            // Använd Supabase-metoden för registrering
            const { error } = await supabase.auth.signUp({
                email,
                password,
            });
            if (error) {
                throw error;
            }
            // Supabase skickar en verifieringslänk till e-postadressen.
            // Du kan informera användaren om detta.
            Alert.alert(
                'Verifiera din e-post',
                'Ett verifieringsmeddelande har skickats till din e-postadress. Vänligen klicka på länken för att bekräfta din registrering.'
            );
        } catch (error) {
            Alert.alert('Registreringsfel', error.message);
        } finally {
            setLoading(false);
        }
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>
                {isLogin ? 'Logga in' : 'Registrera dig'}
            </Text>
            <TextInput
                style={styles.input}
                placeholder="E-post"
                placeholderTextColor="#888"
                value={email}
                onChangeText={setEmail}
                autoCapitalize="none"
                keyboardType="email-address"
            />
            <TextInput
                style={styles.input}
                placeholder="Lösenord"
                placeholderTextColor="#888"
                value={password}
                onChangeText={setPassword}
                secureTextEntry
            />
            {loading ? (
                <ActivityIndicator size="large" color="#e0c097" />
            ) : (
                <>
                    <TouchableOpacity style={styles.button} onPress={isLogin ? handleLogin : handleSignUp}>
                        <Text style={styles.buttonText}>
                            {isLogin ? 'Logga in' : 'Registrera dig'}
                        </Text>
                    </TouchableOpacity>
                    <TouchableOpacity onPress={() => setIsLogin(!isLogin)}>
                        <Text style={styles.toggleText}>
                            {isLogin ? 'Har du inget konto? Registrera dig här.' : 'Har du redan ett konto? Logga in här.'}
                        </Text>
                    </TouchableOpacity>
                </>
            )}
        </View>
    );
};

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
    input: {
        width: '80%',
        height: 50,
        backgroundColor: '#22223b',
        borderColor: '#e0c097',
        borderWidth: 1,
        borderRadius: 10,
        paddingHorizontal: 15,
        marginBottom: 15,
        color: '#e0c097',
    },
    button: {
        backgroundColor: '#e0c097',
        paddingVertical: 15,
        paddingHorizontal: 40,
        borderRadius: 10,
        marginBottom: 15,
        width: '80%',
        alignItems: 'center',
    },
    buttonText: {
        color: '#1a1a2e',
        fontSize: 20,
        fontWeight: 'bold',
    },
    toggleText: {
        color: '#e0c097',
        fontSize: 14,
        marginTop: 10,
        textDecorationLine: 'underline',
    },
});