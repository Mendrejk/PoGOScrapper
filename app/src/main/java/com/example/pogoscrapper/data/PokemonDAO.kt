package com.example.pogoscrapper.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDAO {
    @Query("SELECT * FROM pokemon")
    fun getAll(): List<Pokemon>
    @Query("SELECT * FROM pokemon WHERE `Species Name` LIKE :name")
    fun findByName(name: String): Pokemon

    @Insert
    fun insertAll(vararg pokemon: Pokemon)

    @Update
    fun updateAll(vararg pokemon: Pokemon)

    @Delete
    fun deleteAll()
}