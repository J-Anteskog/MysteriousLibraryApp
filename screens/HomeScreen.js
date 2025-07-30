import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';
import { useNavigation } from '@react-navigation/native';

// Importera translate om du vill använda översättningar på denna skärm
import { translate } from '../utils/i18n';

export default function HomeScreen() {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <Text style={styles.title}>{translate('welcome_title') || 'Welcome to Mysterious Library!'}</Text>
      <Text style={styles.subtitle}>{translate('choose_category') || 'Choose a category to explore:'}</Text>

      {/* Knapp för Runor */}
      <TouchableOpacity
        style={styles.button}
        onPress={() => navigation.navigate('Search')} // Navigera till din befintliga SearchScreen
      >
        <Text style={styles.buttonText}>{translate('runes_category') || 'Runes'}</Text>
      </TouchableOpacity>

      {/* Knapp för Tarot (Placeholder) */}
    <TouchableOpacity
        style={styles.button}
        onPress={() => navigation.navigate('TarotSearch')} // Ändra till att navigera till TarotSearch
    >
        <Text style={styles.buttonText}>{translate('tarot_category') || 'Tarot'}</Text>
    </TouchableOpacity>

      {/* Knapp för Orakel (Placeholder) */}
      <TouchableOpacity
        style={styles.button}
        onPress={() => alert('Oracle coming soon!')} // Tillfällig placeholder
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
    backgroundColor: '#202020', // Anpassa bakgrundsfärgen
    padding: 20,
  },
  title: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#E0E0E0', // Ljus textfärg
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
    backgroundColor: '#6A0DAD', // En lila färg, anpassa gärna
    paddingVertical: 15,
    paddingHorizontal: 40,
    borderRadius: 10,
    marginBottom: 15,
    width: '80%', // Gör knapparna bredare
    alignItems: 'center',
  },
  buttonText: {
    color: '#FFFFFF',
    fontSize: 20,
    fontWeight: 'bold',
  },
});