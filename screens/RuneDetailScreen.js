import React, { useState, useEffect } from 'react';
import { View, ScrollView, StyleSheet, Text } from 'react-native';
import { Image } from 'expo-image';
import LanguageSwitcher from '../components/LanguageSwitcher';
import { addLocaleListener, getCurrentLocale, translate } from '../utils/i18n';
import { useRoute } from '@react-navigation/native';

export default function RuneDetailScreen({ route }) {
  const { rune } = route.params;

  const [locale, setLocale] = useState(getCurrentLocale());
  useEffect(() => {
    const unsubscribe = addLocaleListener(() => {
      setLocale(getCurrentLocale());
    });
    return () => unsubscribe();
  }, []);

  const currentLocale = getCurrentLocale();

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={styles.title}>
        {rune.name}
      </Text>

      <LanguageSwitcher />
      <Image source={rune.image} style={styles.image} resizeMode='contain' />
      <Text style={styles.meaningTitle}>{translate('meaning_title')}</Text>
      <Text style={styles.meaningText}>
        {rune.meaning[currentLocale] || rune.meaning.en}
      </Text>
      <Text style={styles.interpretationTitle}>{translate('interpretation_title')}</Text>
      <Text style={styles.interpretation}>
        {rune.interpretation[currentLocale] || rune.interpretation.en}
      </Text>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 20,
    alignItems: 'center',
    backgroundColor: '#1a1a2e'
  },
  title: {
    fontSize: 28,
    fontFamily: 'CinzelDecorative',
    color: '#e0c097',
    marginBottom: 20
  },
  meaningTitle: {
    fontSize: 18,
    color: '#e0c097',
    marginTop: 20,
    marginBottom: 8,
    fontWeight: 'bold',
    textAlign: 'center'
  },
  meaningText: {
    fontSize: 16,
    color: '#e0c097',
    textAlign: 'center',
    lineHeight: 24
  },
  interpretationTitle: {
    fontSize: 18,
    color: '#e0c097',
    marginTop: 20,
    marginBottom: 8,
    fontWeight: 'bold',
    textAlign: 'center'
  },
  interpretation: {
    fontSize: 16,
    fontStyle: 'italic',
    color: '#e0c097',
    marginTop: 20,
    lineHeight: 24,
    textAlign: 'center'
  },
});