import React from 'react';
import { View, Text, StyleSheet, ScrollView } from 'react-native';
import { Image } from 'expo-image';
import { translate } from '../utils/i18n'; // För översättningar

export default function TarotDetailScreen({ route }) {
  const { card } = route.params; // Här hämtar vi kortdata från navigationen

  if (!card) {
    return (
      <View style={styles.container}>
        <Text style={styles.errorText}>{translate('tarot_not_found') || 'Tarot card not found.'}</Text>
      </View>
    );
  }

  return (
    <ScrollView style={styles.container} contentContainerStyle={styles.contentContainer}>
      <Text style={styles.cardName}>{card.name}</Text>
      <Text style={styles.cardArcana}>{card.arcana}</Text>

      {card.image && (
        <Image source={card.image} style={styles.cardImage} contentFit="contain" />
      )}

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('meaning_upright') || 'Upright Meaning:'}</Text>
        <Text style={styles.sectionText}>{card.meaning.upright}</Text>
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('meaning_reversed') || 'Reversed Meaning:'}</Text>
        <Text style={styles.sectionText}>{card.meaning.reversed}</Text>
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('interpretation_upright') || 'Upright Interpretation:'}</Text>
        <Text style={styles.sectionText}>{card.interpretation.upright}</Text>
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>{translate('interpretation_reversed') || 'Reversed Interpretation:'}</Text>
        <Text style={styles.sectionText}>{card.interpretation.reversed}</Text>
      </View>

    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#202020', // Anpassa bakgrund
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
    width: 200, // Anpassa bredd
    height: 350, // Anpassa höjd
    marginBottom: 25,
    borderRadius: 10,
    backgroundColor: '#333', // Placeholder färg om bilden inte laddas
  },
  section: {
    width: '100%',
    backgroundColor: '#2b2b2b', // Bakgrund för sektioner
    padding: 15,
    borderRadius: 10,
    marginBottom: 15,
    borderWidth: 1,
    borderColor: '#444',
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#6A0DAD', // Lila färg för titlar
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