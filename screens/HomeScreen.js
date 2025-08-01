import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Alert } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import LanguageSwitcher from '../components/LanguageSwitcher';
import { addLocaleListener, getCurrentLocale, translate } from '../utils/i18n';

export default function HomeScreen() {
    const navigation = useNavigation();

    const [locale, setLocale] = useState(getCurrentLocale());
    useEffect(() => {
        const unsubscribe = addLocaleListener(() => {
            setLocale(getCurrentLocale());
        });
        return () => unsubscribe();
    }, []);

    return (
        <View style={styles.container}>
            <Text style={styles.title}>{translate('welcome_title') || 'Welcome to Mysterious Library!'}</Text>
            <Text style={styles.subtitle}>{translate('choose_category') || 'Choose a category to explore:'}</Text>

            {/* Språkväxlare */}
            <LanguageSwitcher />

            {/* Knapp för Runor */}
            <TouchableOpacity
                style={styles.button}
                onPress={() => navigation.navigate('Search')}
            >
                <Text style={styles.buttonText}>{translate('runes_category') || 'Runes'}</Text>
            </TouchableOpacity>

            {/* Knapp för Tarot */}
            <TouchableOpacity
                style={styles.button}
                onPress={() => navigation.navigate('TarotSearch')}
            >
                <Text style={styles.buttonText}>{translate('tarot_category') || 'Tarot'}</Text>
            </TouchableOpacity>

            {/* Knapp för Orakel */}
            <TouchableOpacity
                style={styles.button}
                onPress={() => Alert.alert('Information', 'Oracle coming soon!')}
            >
                <Text style={styles.buttonText}>{translate('oracle_category') || 'Oracle'}</Text>
            </TouchableOpacity>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#202020',
        padding: 20,
    },
    title: {
        fontSize: 28,
        fontWeight: 'bold',
        color: '#E0E0E0',
        marginBottom: 10,
        textAlign: 'center',
    },
    subtitle: {
        fontSize: 18,
        color: '#C0C0C0',
        marginBottom: 30,
        textAlign: 'center',
    },
    button: {
        backgroundColor: '#6A0DAD',
        paddingVertical: 15,
        paddingHorizontal: 40,
        borderRadius: 10,
        marginBottom: 15,
        width: '80%',
        alignItems: 'center',
    },
    buttonText: {
        color: '#FFFFFF',
        fontSize: 20,
        fontWeight: 'bold',
    },
});