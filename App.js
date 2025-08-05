import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import * as Font from 'expo-font';
import { useEffect, useState } from 'react';
import { ActivityIndicator, View } from 'react-native';

// Nya importer för autentiseringspersistence
import { initializeAuth, getReactNativePersistence } from 'firebase/auth';
import ReactNativeAsyncStorage from '@react-native-async-storage/async-storage';
import { onAuthStateChanged } from 'firebase/auth';
import { initializeApp } from 'firebase/app';

// Importera alla skärmkomponenter
import HomeScreen from './screens/HomeScreen';
import TarotSearchScreen from './screens/TarotSearchScreen';
import TarotDetailScreen from './screens/TarotDetailScreen';
import RuneDetailScreen from './screens/RuneDetailScreen';
import SearchScreen from './screens/SearchScreen';
import LoginScreen from './screens/LoginScreen';
import WelcomeScreen from './screens/WelcomeScreen';

// Importera språkhanteringsfunktioner
import { addLocaleListener, getCurrentLocale, translate } from './utils/i18n';

// Ersätt dessa med din faktiska Firebase-konfiguration
import {
  FIREBASE_API_KEY,
  FIREBASE_AUTH_DOMAIN,
  FIREBASE_PROJECT_ID,
  FIREBASE_STORAGE_BUCKET,
  FIREBASE_MESSAGING_SENDER_ID,
  FIREBASE_APP_ID
} from "@env";

const firebaseConfig = {
  apiKey: FIREBASE_API_KEY,
  authDomain: FIREBASE_AUTH_DOMAIN,
  projectId: FIREBASE_PROJECT_ID,
  storageBucket: FIREBASE_STORAGE_BUCKET,
  messagingSenderId: FIREBASE_MESSAGING_SENDER_ID,
  appId: FIREBASE_APP_ID,
};

const app = initializeApp(firebaseConfig);

// Ändrade till den nya metoden för att initiera auth med persistence
export const auth = initializeAuth(app, {
  persistence: getReactNativePersistence(ReactNativeAsyncStorage)
});

const Stack = createStackNavigator();

const AuthFlowStack = () => {
  const AuthStack = createStackNavigator();
  return (
    <AuthStack.Navigator screenOptions={{ headerShown: false }}>
      <AuthStack.Screen name="Login" component={LoginScreen} />
    </AuthStack.Navigator>
  );
};

const MainStack = () => {
  const MainStack = createStackNavigator();
  return (
    <MainStack.Navigator screenOptions={{ headerShown: false }}>
      <MainStack.Screen name="Home" component={HomeScreen} />
      <MainStack.Screen name="Search" component={SearchScreen} options={{ title: translate('search_title') }} />
      <MainStack.Screen name="RuneDetail" component={RuneDetailScreen} options={{ title: translate('rune_detail_title') }} />
      <MainStack.Screen name="TarotSearch" component={TarotSearchScreen} options={{ title: translate('tarot_search_title') }} />
      <MainStack.Screen name="TarotDetail" component={TarotDetailScreen} options={{ title: translate('tarot_detail_title') }} />
    </MainStack.Navigator>
  );
};

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
    const unsubscribe = onAuthStateChanged(auth, (authUser) => {
      setUser(authUser);
      if (initializing) {
        setInitializing(false);
      }
    });
    return () => unsubscribe();
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
            <Stack.Screen name="Main" component={MainStack} />
          </>
        ) : (
          <>
            <Stack.Screen name="Welcome" component={WelcomeScreen} />
            <Stack.Screen name="AuthFlow" component={AuthFlowStack} />
            <Stack.Screen name="Main" component={MainStack} />
          </>
        )}
      </Stack.Navigator>
    </NavigationContainer>
  );
}
