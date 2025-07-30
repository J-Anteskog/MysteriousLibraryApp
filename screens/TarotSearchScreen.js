import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  FlatList,
  TextInput,
  StyleSheet,
  TouchableOpacity,
} from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { Image } from 'expo-image'; // Använd Expo Image för bättre prestanda

// Importera translate
import { translate } from '../utils/i18n';
// Importera DINA tarot-kort
import { tarotCards } from '../data/tarotCards'; // Se till att sökvägen stämmer

export default function TarotSearchScreen() {
  const navigation = useNavigation();
  const [searchQuery, setSearchQuery] = useState('');
  const [filteredCards, setFilteredCards] = useState(tarotCards); // Använd tarotCards här

  useEffect(() => {
    const lowerCaseQuery = searchQuery.toLowerCase();
    const filtered = tarotCards.filter(
      (card) =>
        card.name.toLowerCase().includes(lowerCaseQuery) ||
        card.meaning.upright.toLowerCase().includes(lowerCaseQuery) ||
        card.meaning.reversed.toLowerCase().includes(lowerCaseQuery)
    );
    setFilteredCards(filtered);
  }, [searchQuery]);

  const renderCardItem = ({ item }) => (
    <TouchableOpacity
      style={styles.cardItem}
      onPress={() => navigation.navigate('TarotDetail', { card: item })} // Ny destinationsskärm: TarotDetail
    >
      <Image source={item.image} style={styles.cardImage} contentFit="contain" />
      <Text style={styles.cardName}>{item.name}</Text>
    </TouchableOpacity>
  );

  return (
    <View style={styles.container}>
      <Text style={styles.headerTitle}>{translate('tarot_search_title') || 'Tarot Card Search'}</Text>
      <TextInput
        style={styles.searchInput}
        placeholder={translate('search_tarot_placeholder') || 'Search Tarot cards...'}
        placeholderTextColor="#888"
        value={searchQuery}
        onChangeText={setSearchQuery}
      />
      <FlatList
        data={filteredCards}
        keyExtractor={(item) => item.id}
        renderItem={renderCardItem}
        contentContainerStyle={styles.listContent}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#202020', // Anpassa bakgrund
    paddingHorizontal: 15,
    paddingTop: 20,
  },
  headerTitle: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#E0E0E0',
    marginBottom: 20,
    textAlign: 'center',
  },
  searchInput: {
    backgroundColor: '#333',
    color: '#E0E0E0',
    padding: 12,
    borderRadius: 8,
    fontSize: 16,
    marginBottom: 15,
  },
  cardItem: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#2b2b2b', // Anpassa bakgrund
    padding: 10,
    borderRadius: 8,
    marginBottom: 10,
    borderWidth: 1,
    borderColor: '#444',
  },
  cardImage: {
    width: 50,
    height: 80, // Anpassa storlek för tarot-kort
    marginRight: 15,
    resizeMode: 'contain',
  },
  cardName: {
    color: '#E0E0E0',
    fontSize: 18,
    fontWeight: 'bold',
  },
  listContent: {
    paddingBottom: 20, // Lägg till lite padding i botten
  },
});