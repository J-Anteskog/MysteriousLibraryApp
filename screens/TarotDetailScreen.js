import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';
import { Image } from 'expo-image';
import LanguageSwitcher from '../components/LanguageSwitcher';
import { addLocaleListener, getCurrentLocale, translate } from '../utils/i18n';
import { useRoute } from '@react-navigation/native';

export default function TarotDetailScreen() {
  const route = useRoute();
  const { card } = route.params;

  const [locale, setLocale] = useState(getCurrentLocale());
  useEffect(() => {
    const unsubscribe = addLocaleListener(() => {
      setLocale(getCurrentLocale());
    });
    return () => unsubscribe();
  }, []);

  if (!card) {
    return (
      <View style={styles.container}>
        <Text style={styles.errorText}>{translate('tarot_not_found')}</Text>
      </View>
    );
  }

  const currentLocale = getCurrentLocale();
  const getMeaning = (type) => card.meaning[currentLocale][type] || card.meaning.en[type];
  const getInterpretation = (type) => card.interpretation[currentLocale][type] || card.interpretation.en[type];

  return (
    <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
      <Text style={styles.cardName}>{card.name}</Text>
      <Text style={styles.cardArcana}>{card.arcana}</Text>
      <LanguageSwitcher />
      {card.image && (
        <Image source={card.image} style={styles.cardImage} contentFit="contain" />
      )}
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('meaning_upright')}</Text>
        <Text style={styles.sectionText}>{getMeaning('upright')}</Text>
      </View>
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('meaning_reversed')}</Text>
        <Text style={styles.sectionText}>{getMeaning('reversed')}</Text>
      </View>
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('interpretation_upright')}</Text>
        <Text style={styles.sectionText}>{getInterpretation('upright')}</Text>
      </View>
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('interpretation_reversed')}</Text>
        <Text style={styles.sectionText}>{getInterpretation('reversed')}</Text>
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#202020',
  },
  contentContainer: {
    padding: 20,
    alignItems: 'center',
  },
  cardName: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#E0E0E0',
    marginBottom: 5,
    textAlign: 'center',
  },
  cardArcana: {
    fontSize: 18,
    color: '#C0C0C0',
    marginBottom: 20,
    textAlign: 'center',
  },
  cardImage: {
    width: 200,
    height: 350,
    marginBottom: 25,
    borderRadius: 10,
    backgroundColor: '#333',
  },
  section: {
    width: '100%',
    backgroundColor: '#2b2b2b',
    padding: 15,
    borderRadius: 10,
    marginBottom: 15,
    borderWidth: 1,
    borderColor: '#444',
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#6A0DAD',
    marginBottom: 5,
  },
  sectionText: {
    fontSize: 16,
    color: '#E0E0E0',
    lineHeight: 24,
  },
  errorText: {
    color: 'red',
    fontSize: 18,
    textAlign: 'center',
    marginTop: 50,
  }
});