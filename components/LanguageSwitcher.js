// components/LanguageSwitcher.js
import React from 'react';
import { View, TouchableOpacity, Text, StyleSheet } from 'react-native';
import { setLocale, getCurrentLocale } from '../utils/i18n'; // Importera setLocale och getCurrentLocale

export default function LanguageSwitcher() {
  const currentLocale = getCurrentLocale();

  const handleLanguageChange = (locale) => {
    setLocale(locale);
  };

  return (
    <View style={styles.container}>
      <TouchableOpacity
        style={[styles.button, currentLocale === 'en' && styles.activeButton]}
        onPress={() => handleLanguageChange('en')}
      >
        <Text style={[styles.buttonText, currentLocale === 'en' && styles.activeButtonText]}>English</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={[styles.button, currentLocale === 'sv' && styles.activeButton]}
        onPress={() => handleLanguageChange('sv')}
      >
        <Text style={[styles.buttonText, currentLocale === 'sv' && styles.activeButtonText]}>Svenska</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    justifyContent: 'center',
    marginBottom: 20, // Ger lite utrymme under knapparna
    marginTop: 10, // Ger lite utrymme ovanför
  },
  button: {
    paddingVertical: 8,
    paddingHorizontal: 15,
    borderRadius: 5,
    borderWidth: 1,
    borderColor: '#888', // Grå ram
    marginHorizontal: 5,
    backgroundColor: '#333', // Mörk bakgrund
  },
  activeButton: {
    backgroundColor: '#6A0DAD', // Lila bakgrund när aktiv
    borderColor: '#6A0DAD',
  },
  buttonText: {
    color: '#E0E0E0', // Ljus text
    fontSize: 16,
  },
  activeButtonText: {
    color: '#FFFFFF', // Vit text när aktiv
    fontWeight: 'bold',
  },
});