// supabaseClient.js
import { createClient } from '@supabase/supabase-js';
import {
  SUPABASE_URL,
  SUPABASE_ANON_KEY
} from "@env";

// Skapa en enda Supabase-klient för din app
export const supabase = createClient(SUPABASE_URL, SUPABASE_ANON_KEY);