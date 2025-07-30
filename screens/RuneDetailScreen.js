import { Image, ScrollView, StyleSheet, Text } from 'react-native';
// Importera även getCurrentLocale från din i18n-fil
import { getCurrentLocale, translate } from '../utils/i18n';

export default function RuneDetailScreen ({ route }) {
  const { rune } = route.params;
  // Hämta den aktuella språkkoden från din i18n-instans
  const currentLocale = getCurrentLocale();

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={styles.title}>
        {rune.name}
      </Text>
      <Image source={rune.image} style={styles.image} resizeMode='contain' />
      <Text style={styles.meaningTitle}>{translate('meaning_title')}</Text>
      <Text style={styles.meaningText}>
        {/* Använd den aktuella språkkoden för att hämta rätt betydelse.
            Om översättningen för det aktuella språket saknas, fallbackerar vi till engelska (rune.meaning.en).
            Det är viktigt att varje runobjekt har en 'en' version. */}
        {rune.meaning[currentLocale] || rune.meaning.en}
      </Text>
      <Text style={styles.interpretationTitle}>{translate('interpretation_title')}</Text>
      <Text style={styles.interpretation}>
        {/* Gör samma sak för tolkningen */}
        {rune.interpretation[currentLocale] || rune.interpretation.en}
      </Text>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 20,
    alignItems: 'center',
    backgroundColor: '#1a1a2e' // Mörkblå-lila
  },
  title: {
    fontSize: 28,
    fontFamily: 'CinzelDecorative',
    color: '#e0c097', // Guldaktig
    marginBottom: 20
  },
  meaningTitle: {
    fontSize: 18,
    color: '#e0c097', // Ljusare färg
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