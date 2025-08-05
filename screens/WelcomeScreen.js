import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Switch } from 'react-native';
import { translate, getCurrentLocale, setLocale } from '../utils/i18n';

// Skapar en enkel komponent för att byta språk
const LanguageSwitcher = () => {
    const [isSwedish, setIsSwedish] = useState(getCurrentLocale() === 'sv');

    const toggleLanguage = () => {
        const newLocale = isSwedish ? 'en' : 'sv';
        setLocale(newLocale);
        setIsSwedish(!isSwedish);
    };

    return (
        <View style={styles.languageSwitcherContainer}>
            <Text style={styles.languageText}>EN</Text>
            <Switch
                onValueChange={toggleLanguage}
                value={isSwedish}
                thumbColor={isSwedish ? '#e0c097' : '#f4f3f4'}
                trackColor={{ false: '#33334d', true: '#e0c097' }}
            />
            <Text style={styles.languageText}>SV</Text>
        </View>
    );
};

export default function WelcomeScreen({ navigation }) {
    const navigateToLogin = () => {
        navigation.navigate('AuthFlow', { screen: 'Login' });
    };

    const navigateAsGuest = () => {
        navigation.navigate('Main');
    };

    return (
        <View style={styles.container}>
            <LanguageSwitcher />
            <Text style={styles.title}>{translate('welcome_to_app')}</Text>
            <Text style={styles.subtitle}>{translate('welcome_choose_option')}</Text>

            <TouchableOpacity style={styles.button} onPress={navigateToLogin}>
                <Text style={styles.buttonText}>{translate('login_signup_button')}</Text>
            </TouchableOpacity>

            <TouchableOpacity style={[styles.button, styles.guestButton]} onPress={navigateAsGuest}>
                <Text style={styles.buttonText}>{translate('continue_as_guest_button')}</Text>
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
        fontSize: 28,
        fontWeight: 'bold',
        color: '#e0c097',
        marginBottom: 10,
        textAlign: 'center',
    },
    subtitle: {
        fontSize: 16,
        color: '#e0c097',
        marginBottom: 40,
        textAlign: 'center',
    },
    button: {
        backgroundColor: '#e0c097',
        paddingVertical: 15,
        paddingHorizontal: 30,
        borderRadius: 10,
        marginBottom: 15,
        width: '80%',
        alignItems: 'center',
    },
    buttonText: {
        color: '#1a1a2e',
        fontSize: 18,
        fontWeight: 'bold',
    },
    guestButton: {
        backgroundColor: '#33334d',
    },
    languageSwitcherContainer: {
        position: 'absolute',
        top: 60,
        right: 20,
        flexDirection: 'row',
        alignItems: 'center',
    },
    languageText: {
        color: '#e0c097',
        fontSize: 16,
        fontWeight: 'bold',
        marginHorizontal: 5,
    },
});
