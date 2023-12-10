package com.example.pogoscrapper.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDAO(): PokemonDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(applicationContext: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE != null) {
                    return INSTANCE as AppDatabase
                }

                INSTANCE = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "pokemon_database"
                ).build()

                return INSTANCE as AppDatabase
            }
        }
    }
}