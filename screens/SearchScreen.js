import { useState } from 'react';
import { FlatList, Image, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';
import runes from '../data/runes';
import { setLocale, translate } from '../utils/i18n'; // Importera setLocale härifrån

export default function SearchScreen({ navigation }) {
  const [query, setQuery] = useState('');

  const filteredRunes = runes.filter(rune =>
    rune.name.toLowerCase().includes(query.toLowerCase())
  );

  return (
    <View style={styles.container}>
      {/* Lägg till knappar för språkval */}
      <View style={styles.languageButtonsContainer}>
        <TouchableOpacity style={styles.languageButton} onPress={() => setLocale('en')}>
          <Text style={styles.languageButtonText}>English</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.languageButton} onPress={() => setLocale('sv')}>
          <Text style={styles.languageButtonText}>Svenska</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.infoBox}>
        <Text style={styles.infoText}>
          {translate('info_box_text')}
        </Text>
      </View>
      <TextInput
        style={styles.input}
        placeholder={translate('search_placeholder')}
        placeholderTextColor="#e0c097"
        value={query}
        onChangeText={setQuery}
      />
      <FlatList
        data={filteredRunes}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <TouchableOpacity
            style={styles.item}
            onPress={() => navigation.navigate('RuneDetail', { rune: item })}
          >
            <Image source={item.image} style={styles.runeThumbnail} />
            <Text style={styles.itemText}>{item.name}</Text>
          </TouchableOpacity>
        )}
        ListEmptyComponent={<Text style={styles.emptyText}>{translate('no_runes_found')}</Text>}
        style={styles.flatListStyle}
      />
    </View>
  );
}

const styles = StyleSheet.create({
    flatListStyle: {
    flex: 1,
  },
  container: {
    padding: 20,
    backgroundColor: '#1a1a2e',
    flexGrow: 1,
  },
  input: {
    height: 40,
    borderColor: '#e0c097',
    borderWidth: 1,
    borderRadius: 6,
    paddingHorizontal: 10,
    marginBottom: 15,
    color: '#e0c097',
    backgroundColor: '#22223b',
  },
  item: {
    paddingVertical: 15,
    borderBottomColor: '#e0c097',
    borderBottomWidth: 1,
    flexDirection: 'row',
    alignItems: 'center',
  },
  runeThumbnail: {
    width: 30,
    height: 30,
    marginRight: 10,
    resizeMode: 'contain',
  },
  itemText: {
    fontSize: 18,
    fontFamily: 'CinzelDecorative',
    color: '#e0c097',
  },
  emptyText: {
    textAlign: 'center',
    marginTop: 20,
    fontStyle: 'italic',
    color: '#888',
  },
  infoBox: {
    backgroundColor: '#22223b',
    borderRadius: 10,
    padding: 15,
    marginBottom: 20,
    borderWidth: 1,
    borderColor: '#e0c097',
    width: '100%',
  },
  infoText: {
    color: '#e0c097',
    fontSize: 15,
    textAlign: 'center',
  },
  // Nya stilar för språkvalsknapparna
  languageButtonsContainer: {
    flexDirection: 'row',
    justifyContent: 'center',
    // Lägg till lite marginal om du vill
    marginBottom: 15,
  },
  languageButton: {
    backgroundColor: '#3a3a5e', // En mörkare bakgrund för knapparna
    paddingVertical: 8,
    paddingHorizontal: 15,
    borderRadius: 5,
    marginHorizontal: 5, // Lite utrymme mellan knapparna
  },
  languageButtonText: {
    color: '#e0c097', // Samma guldaktiga färg som övrig text
    fontSize: 16,
  },
});