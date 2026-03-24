package com.example.network.data.supabase

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

//24.03.2026
//Алексей
//объект подключения к supabase
object Connect {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://pguqpsxipxezvjyiaxwk.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBndXFwc3hpcHhlenZqeWlheHdrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzQyNjI2MzMsImV4cCI6MjA4OTgzODYzM30.e_eKB8OyW2XD-xmt4xyul802bvKFe82WeaicFowHndQ"
    ){
        install(Postgrest)
        install(Auth)
    }
}