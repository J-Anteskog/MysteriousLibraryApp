import * as Localization from 'expo-localization';
import { I18n } from 'i18n-js';

import en from '../translations/en.json';
import sv from '../translations/sv.json';

const i18n = new I18n({
  en,
  sv
});

const defaultLanguage = 'en';
i18n.locale = (Localization.locale?.split('-')[0] ?? defaultLanguage);
i18n.fallbacks = true;

// Lägg till en enkel event emitter
const listeners = new Set();
const emitChange = () => {
  listeners.forEach(listener => listener());
};

export const translate = (scope, options) => i18n.t(scope, options);
export const getCurrentLocale = () => i18n.locale;
export const setLocale = (newLocale) => {
  i18n.locale = newLocale;
  emitChange(); // <--- Kalla på denna när språket ändras
};

// Exportera funktioner för att lägga till/ta bort lyssnare
export const addLocaleListener = (callback) => {
  listeners.add(callback);
  return () => listeners.delete(callback); // Returnera en cleanup-funktion
};


export default i18n;