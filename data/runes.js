const runes = [
  {
    id: 'fehu',
    name: 'Fehu',
    image: require('../assets/images/fehu.png'),
    meaning: {
      en: 'Wealth, prosperity, abundance, success.',
      sv: 'Rikedom, välstånd, överflöd, framgång.'
    },
    interpretation: {
      en: 'Fehu represents material wealth and prosperity. It signifies the flow of resources and the importance of sharing and generosity in achieving abundance.',
      sv: 'Fehu representerar materiell rikedom och välstånd. Den symboliserar flödet av resurser och vikten av delning och generositet för att uppnå överflöd.'
    },
  },
  {
    id: 'uruz',
    name: 'Uruz',
    image: require('../assets/images/uruz.png'),
    meaning: {
      en: 'Strength, health, endurance, courage.',
      sv: 'Styrka, hälsa, uthållighet, mod.'
    },
    interpretation: {
      en: 'Uruz symbolizes physical strength and vitality. It encourages resilience and the courage to face challenges, promoting personal growth through overcoming obstacles.',
      sv: 'Uruz symboliserar fysisk styrka och vitalitet. Den uppmuntrar motståndskraft och mod att möta utmaningar, vilket främjar personlig utveckling genom att övervinna hinder.'
    },
  },
  {
    id: 'thurisaz',
    name: 'Thurisaz',
    image: require('../assets/images/thurisaz.png'),
    meaning: {
      en: 'Protection, conflict, challenge, defense.',
      sv: 'Skydd, konflikt, utmaning, försvar.'
    },
    interpretation: {
      en: 'Thurisaz represents the power of protection and the need to confront challenges. It signifies the importance of boundaries and the strength to defend oneself against adversity.',
      sv: 'Thurisaz representerar skyddets kraft och behovet av att konfrontera utmaningar. Den symboliserar vikten av gränser och styrkan att försvara sig mot motgångar.'
    },
  },
    {
        id: 'ansuz',
        name: 'Ansuz',
        image: require('../assets/images/ansuz.png'),
        meaning: {
          en: 'Wisdom, communication, knowledge, insight.',
          sv: 'Visdom, kommunikation, kunskap, insikt.'
        },
        interpretation: {
          en: 'Ansuz symbolizes divine communication and the pursuit of knowledge. It encourages clarity in expression and the sharing of wisdom, fostering understanding and insight.',
          sv: 'Ansuz symboliserar gudomlig kommunikation och strävan efter kunskap. Den uppmuntrar tydlighet i uttryck och delning av visdom, vilket främjar förståelse och insikt.'
        },
    },
    {
        id: 'raido',
        name: 'Raido',
        image: require('../assets/images/raido.png'),
        meaning: {
          en: 'Journey, movement, travel, progress.',
          sv: 'Resa, rörelse, framsteg.'
        },
        interpretation: {
          en: 'Raido signifies movement and the journey of life. It represents progress, both physically and spiritually, encouraging exploration and the pursuit of new experiences.',
          sv: 'Raido symboliserar rörelse och livets resa. Den representerar framsteg, både fysiskt och andligt, och uppmuntrar utforskning och strävan efter nya upplevelser.'
        },
    },
    {
        id: 'kaunan',
        name: 'Kaunan',
        image: require('../assets/images/kaunan.png'),
        meaning: {
          en: 'Creativity, transformation, fire, passion.',
          sv: 'Kreativitet, transformation, eld, passion.'
        },
        interpretation: {
          en: 'Kaunan embodies the creative force and transformative power of fire. It encourages embracing passion and creativity, fostering personal transformation through artistic expression.',
          sv: 'Kaunan förkroppsligar den kreativa kraften och eldens transformativa förmåga. Den uppmuntrar att omfamna passion och kreativitet, vilket främjar personlig transformation genom konstnärliga uttryck.'
        },
    },
    {
        id: 'gebo',
        name: 'Gebo',
        image: require('../assets/images/gebo.png'),
        meaning: {
          en: 'Gift, partnership, balance, generosity.',
          sv: 'Gåva, partnerskap, balans, generositet.'
        },
        interpretation: {
          en: 'Gebo represents the concept of giving and receiving. It signifies the importance of balance in relationships and the value of generosity, fostering harmony and partnership.',
          sv: 'Gebo representerar konceptet att ge och ta emot. Den symboliserar vikten av balans i relationer och värdet av generositet, vilket främjar harmoni och partnerskap.'
        },
    },
    {
        id: 'wunjo',
        name: 'Wunjo',
        image: require('../assets/images/wunjo.png'),
        meaning: {
          en: 'Joy, harmony, success, fulfillment.',
          sv: 'Glädje, harmoni, framgång, uppfyllelse.'
        },
        interpretation: {
          en: 'Wunjo symbolizes joy and harmony in life. It represents the fulfillment of desires and the achievement of goals, encouraging a positive outlook and celebration of success.',
          sv: 'Wunjo symboliserar glädje och harmoni i livet. Den representerar uppfyllelsen av önskningar och uppnåendet av mål, vilket uppmuntrar en positiv inställning och firande av framgång.'
        },
    },
    {
        id: 'hagalaz',
        name: 'Hagalaz',
        image: require('../assets/images/hagalaz.png'),
        meaning: {
          en: 'Disruption, change, transformation, challenges.',
          sv: 'Störning, förändring, transformation, utmaningar.'
        },
        interpretation: {
          en: 'Hagalaz signifies disruption and the inevitability of change. It represents challenges that lead to transformation, encouraging resilience and adaptability in the face of adversity.',
          sv: 'Hagalaz symboliserar störning och förändringens oundviklighet. Den representerar utmaningar som leder till transformation, vilket uppmuntrar motståndskraft och anpassningsförmåga inför motgångar.'
        },
    },
    {
        id: 'naudhiz',
        name: 'Naudhiz',
        image: require('../assets/images/naudhiz.png'),
        meaning: {
          en: 'Need, necessity, survival, endurance.',
          sv: 'Behov, nödvändighet, överlevnad, uthållighet.'
        },
        interpretation: {
          en: 'Naudhiz represents the concept of necessity and the challenges of survival. It encourages endurance and the ability to overcome hardships, emphasizing the importance of resilience in difficult times.',
          sv: 'Naudhiz representerar konceptet av nödvändighet och överlevnadens utmaningar. Den uppmuntrar uthållighet och förmågan att övervinna svårigheter, vilket betonar vikten av motståndskraft i svåra tider.'
        },
    },
    {
        id: 'isa',
        name: 'Isa',
        image: require('../assets/images/isa.png'),
        meaning: {
          en: 'Stillness, pause, reflection, clarity.',
          sv: 'Stillhet, paus, reflektion, klarhet.'
        },
        interpretation: {
          en: 'Isa symbolizes stillness and the need for reflection. It encourages taking a pause to gain clarity and insight, promoting inner peace and the importance of contemplation in decision-making.',
          sv: 'Isa symboliserar stillhet och behovet av reflektion. Den uppmuntrar att ta en paus för att uppnå klarhet och insikt, vilket främjar inre frid och vikten av kontemplation vid beslutsfattande.'
        },
    },
    {
        id: 'jera',
        name: 'Jera',
        image: require('../assets/images/jera.png'),
        meaning: {
          en: 'Harvest, cycles, patience, growth.',
          sv: 'Skörd, cykler, tålamod, tillväxt.'
        },
        interpretation: {
          en: 'Jera represents the cycles of nature and the rewards of patience. It signifies the importance of timing and the natural flow of growth, encouraging a long-term perspective in achieving goals.',
          sv: 'Jera representerar naturens cykler och tålamodets belöningar. Den symboliserar vikten av timing och tillväxtens naturliga flöde, vilket uppmuntrar ett långsiktigt perspektiv för att uppnå mål.'
        },
    },
    {
        id: 'eihwaz',
        name: 'Eihwaz',
        image: require('../assets/images/eihwaz.png'),
        meaning: {
          en: 'Transformation, protection, defense, resilience.',
          sv: 'Transformation, skydd, försvar, motståndskraft.'
        },
        interpretation: {
          en: 'Eihwaz symbolizes transformation and the protective power of resilience. It encourages facing challenges with strength and adaptability, promoting personal growth through overcoming obstacles.',
          sv: 'Eihwaz symboliserar transformation och motståndskraftens skyddande kraft. Den uppmuntrar att möta utmaningar med styrka och anpassningsförmåga, vilket främjar personlig utveckling genom att övervinna hinder.'
        },
    },
    {
        id: 'perthro',
        name: 'Perthro',
        image: require('../assets/images/perthro.png'),
        meaning: {
          en: 'Mystery, fate, chance, secrets.',
          sv: 'Mysterium, öde, slump, hemligheter.'
        },
        interpretation: {
          en: 'Perthro represents the mysteries of fate and the unknown. It signifies the role of chance in life and encourages embracing uncertainty, fostering a sense of wonder and exploration of hidden truths.',
          sv: 'Perthro representerar ödets mysterier och det okända. Den symboliserar slumpens roll i livet och uppmuntrar att omfamna osäkerhet, vilket främjar en känsla av förundran och utforskning av dolda sanningar.'
        },
    },
    {
        id: 'algiz',
        name: 'Algiz',
        image: require('../assets/images/algiz.png'),
        meaning: {
          en: 'Protection, defense, spiritual guidance.',
          sv: 'Skydd, försvar, andlig vägledning.'
        },
        interpretation: {
          en: 'Algiz symbolizes spiritual protection and guidance. It encourages seeking higher wisdom and the importance of safeguarding oneself from negative influences, promoting spiritual growth and awareness.',
          sv: 'Algiz symboliserar andligt skydd och vägledning. Den uppmuntrar att söka högre visdom och vikten av att skydda sig från negativa influenser, vilket främjar andlig tillväxt och medvetenhet.'
        },
    },
    {
        id: 'sowilo',
        name: 'Sowilo',
        image: require('../assets/images/sowilo.png'),
        meaning: {
          en: 'Success, vitality, energy, enlightenment.',
          sv: 'Framgång, vitalitet, energi, upplysning.'
        },
        interpretation: {
          en: 'Sowilo represents the sun and the energy of success. It signifies vitality and enlightenment, encouraging a positive outlook and the pursuit of goals with confidence and enthusiasm.',
          sv: 'Sowilo representerar solen och framgångens energi. Den symboliserar vitalitet och upplysning, vilket uppmuntrar en positiv inställning och strävan efter mål med tillförsikt och entusiasm.'
        },
    },
    {
        id: 'tiwaz',
        name: 'Tiwaz',
        image: require('../assets/images/tiwaz.png'),
        meaning: {
          en: 'Justice, honor, leadership, sacrifice.',
          sv: 'Rättvisa, ära, ledarskap, uppoffring.'
        },
        interpretation: {
          en: 'Tiwaz symbolizes justice and the qualities of a true leader. It encourages honor and sacrifice for the greater good, promoting integrity and the pursuit of noble causes.',
          sv: 'Tiwaz symboliserar rättvisa och egenskaperna hos en sann ledare. Den uppmuntrar ära och uppoffring för det större goda, vilket främjar integritet och strävan efter ädla syften.'
        },
    },
    {
        id: 'berkanan',
        name: 'Berkanan',
        image: require('../assets/images/berkanan.png'),
        meaning: {
          en: 'Fertility, growth, new beginnings, nurturing.',
          sv: 'Fruktsamhet, tillväxt, nya början, omvårdnad.'
        },
        interpretation: {
          en: 'Berkanan represents fertility and the nurturing aspect of growth. It signifies new beginnings and the importance of care and support in fostering development, both personally and in relationships.',
          sv: 'Berkanan representerar fruktsamhet och tillväxtens omvårdande aspekt. Den symboliserar nya början och vikten av omsorg och stöd för att främja utveckling, både personligt och i relationer.'
        },
    },
    {
        id: 'ehwaz',
        name: 'Ehwaz',
        image: require('../assets/images/ehwaz.png'),
        meaning: {
          en: 'Movement, progress, partnership, trust.',
          sv: 'Rörelse, framsteg, partnerskap, förtroende.'
        },
        interpretation: {
          en: 'Ehwaz symbolizes movement and the dynamics of partnership. It encourages trust and cooperation in relationships, promoting progress through collaboration and shared goals.',
          sv: 'Ehwaz symboliserar rörelse och dynamiken i partnerskap. Den uppmuntrar tillit och samarbete i relationer, vilket främjar framsteg genom samarbete och gemensamma mål.'
        },
    },
    {
        id: 'mannaz',
        name: 'Mannaz',
        image: require('../assets/images/mannaz.png'),
        meaning: {
          en: 'Humanity, community, cooperation, self-awareness.',
          sv: 'Mänsklighet, gemenskap, samarbete, självmedvetenhet.'
        },
        interpretation: {
          en: 'Mannaz represents the essence of humanity and the importance of community. It encourages self-awareness and cooperation, fostering a sense of belonging and shared purpose among individuals.',
          sv: 'Mannaz representerar mänsklighetens essens och vikten av gemenskap. Den uppmuntrar självmedvetenhet och samarbete, vilket främjar en känsla av tillhörighet och gemensamt syfte bland individer.'
        },
    },
    {
        id: 'lagu',
        name: 'Lagu',
        image: require('../assets/images/lagu.png'),
        meaning: {
          en: 'Flow, intuition, emotions, the subconscious.',
          sv: 'Flöde, intuition, känslor, det undermedvetna.'
        },
        interpretation: {
          en: 'Lagu symbolizes the flow of emotions and intuition. It encourages connecting with the subconscious and trusting one’s inner voice, promoting emotional intelligence and understanding.',
          sv: 'Lagu symboliserar känslornas flöde och intuition. Den uppmuntrar att koppla samman med det undermedvetna och lita på sin inre röst, vilket främjar emotionell intelligens och förståelse.'
        },
    },
    {
        id: 'ingwaz',
        name: 'Ingwaz',
        image: require('../assets/images/ingwaz.png'),
        meaning: {
          en: 'Fertility, potential, completion, new beginnings.',
          sv: 'Fruktsamhet, potential, fullbordan, nya början.'
        },
        interpretation: {
          en: 'Ingwaz represents the potential for new beginnings and the completion of cycles. It signifies fertility in ideas and projects, encouraging the nurturing of new ventures and the realization of goals.',
          sv: 'Ingwaz representerar potentialen för nya början och fullbordandet av cykler. Den symboliserar fruktsamhet i idéer och projekt, vilket uppmuntrar omvårdnad av nya satsningar och förverkligandet av mål.'
        },
    },
    {
        id: 'dagaz',
        name: 'Dagaz',
        image: require('../assets/images/dagaz.png'),
        meaning: {
          en: 'Breakthrough, awakening, transformation, clarity.',
          sv: 'Genombrott, uppvaknande, transformation, klarhet.'
        },
        interpretation: {
          en: 'Dagaz symbolizes breakthrough and transformation. It represents the dawn of new understanding and clarity, encouraging a fresh perspective and the realization of potential through awakening.',
          sv: 'Dagaz symboliserar genombrott och transformation. Den representerar gryningen av ny förståelse och klarhet, vilket uppmuntrar ett nytt perspektiv och förverkligandet av potential genom uppvaknande.'
        },
    },
    {
        id: 'othala',
        name: 'Othala',
        image: require('../assets/images/othala.png'),
        meaning: {
          en: 'Heritage, ancestry, home, family.',
          sv: 'Arv, släktskap, hem, familj.'
        },
        interpretation: {
          en: 'Othala represents the importance of heritage and family. It signifies a connection to one’s roots and the value of home, encouraging the preservation of traditions and the nurturing of familial bonds.',
          sv: 'Othala representerar vikten av arv och familj. Den symboliserar en koppling till ens rötter och hemmets värde, vilket uppmuntrar bevarandet av traditioner och omvårdnaden av familjeband.'
        },
    },
];

export default runes;