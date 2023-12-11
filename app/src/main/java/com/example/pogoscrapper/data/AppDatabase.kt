package com.example.pogoscrapper.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson

@Database(entities = [Pokemon::class], version = 1)
@TypeConverters(Converters::class)
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
                ).allowMainThreadQueries().build() // TODO: use coroutines instead of allowMainThreadQueries()

                return INSTANCE as AppDatabase
            }
        }
    }
}

class Converters {
    @TypeConverter
    fun stringListToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}