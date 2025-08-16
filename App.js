// App.js
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import * as Font from 'expo-font';
import { useEffect, useState } from 'react';
import { ActivityIndicator, View } from 'react-native';
import { Ionicons } from '@expo/vector-icons';

// Importera den nya Supabase-klienten
import { supabase } from './supabaseClient';

// Importera alla skärmkomponenter
import HomeScreen from './screens/HomeScreen';
import TarotSearchScreen from './screens/TarotSearchScreen';
import TarotDetailScreen from './screens/TarotDetailScreen';
import RuneDetailScreen from './screens/RuneDetailScreen';
import SearchScreen from './screens/SearchScreen';
import LoginScreen from './screens/LoginScreen';
import WelcomeScreen from './screens/WelcomeScreen';
import ProfileScreen from './screens/ProfileScreen';

// Importera språkhanteringsfunktioner
import { addLocaleListener, getCurrentLocale, translate } from './utils/i18n';

// All Firebase-relaterad kod har tagits bort härifrån

const Stack = createStackNavigator();
const Tab = createBottomTabNavigator();

// Navigator för inloggning/registrering
const AuthFlowStack = () => {
  return (
    <Stack.Navigator screenOptions={{ headerShown: false }}>
      <Stack.Screen name="Login" component={LoginScreen} />
    </Stack.Navigator>
  );
};

// Huvudnavigator som hanterar sök- och detaljsidor
const MainStack = () => {
  return (
    <Stack.Navigator screenOptions={{ headerShown: false }}>
      <Stack.Screen name="Home" component={HomeScreen} />
      <Stack.Screen name="Search" component={SearchScreen} options={{ title: translate('search_title') }} />
      <Stack.Screen name="RuneDetail" component={RuneDetailScreen} options={{ title: translate('rune_detail_title') }} />
      <Stack.Screen name="TarotSearch" component={TarotSearchScreen} options={{ title: translate('tarot_search_title') }} />
      <Stack.Screen name="TarotDetail" component={TarotDetailScreen} options={{ title: translate('tarot_detail_title') }} />
    </Stack.Navigator>
  );
};

// Fliknavigator som visas när användaren är inloggad
const LoggedInTabs = () => {
  return (
    <Tab.Navigator
      screenOptions={({ route }) => ({
        headerShown: false,
        tabBarIcon: ({ focused, color, size }) => {
          let iconName;

          if (route.name === 'HomeStack') {
            iconName = focused ? 'home' : 'home-outline';
          } else if (route.name === 'Profile') {
            iconName = focused ? 'person' : 'person-outline';
          }

          return <Ionicons name={iconName} size={size} color={color} />;
        },
        tabBarActiveTintColor: '#e0c097',
        tabBarInactiveTintColor: 'gray',
        tabBarStyle: {
          backgroundColor: '#1a1a2e',
          borderTopWidth: 0
        },
      })}
    >
      <Tab.Screen name="HomeStack" component={MainStack} options={{ title: "Hem" }} />
      <Tab.Screen name="Profile" component={ProfileScreen} options={{ title: "Profil" }} />
    </Tab.Navigator>
  );
};

// Huvudkomponenten som hanterar inloggningstillståndet
export default function App() {
  const [fontsLoaded, setFontsLoaded] = useState(false);
  const [initializing, setInitializing] = useState(true);
  const [user, setUser] = useState(null);

  useEffect(() => {
    async function loadFonts() {
      await Font.loadAsync({
        'CinzelDecorative': require('./assets/fonts/CinzelDecorative-Regular.ttf'),
      });
      setFontsLoaded(true);
    }
    loadFonts();
  }, []);

  useEffect(() => {
    // Supabase har en annan metod för att lyssna på autentisering
    const { data: { subscription } } = supabase.auth.onAuthStateChange((_event, session) => {
      setUser(session?.user ?? null);
      if (initializing) {
        setInitializing(false);
      }
    });
    return () => subscription.unsubscribe();
  }, [initializing]);

  if (!fontsLoaded || initializing) {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <ActivityIndicator size="large" />
      </View>
    );
  }

  return (
    <NavigationContainer>
      <Stack.Navigator screenOptions={{ headerShown: false }}>
        {user ? (
          <>
            <Stack.Screen name="LoggedInTabs" component={LoggedInTabs} />
          </>
        ) : (
          <>
            <Stack.Screen name="Welcome" component={WelcomeScreen} />
            <Stack.Screen name="AuthFlow" component={AuthFlowStack} />
          </>
        )}
      </Stack.Navigator>
    </NavigationContainer>
  );
}