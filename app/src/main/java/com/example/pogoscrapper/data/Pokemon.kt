package com.example.pogoscrapper.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "Species Name") val name: String,
    @ColumnInfo(name = "Great League Score") val ratingGL: Int?,
    @ColumnInfo(name = "Ultra League Score") val ratingUL: Int?,
    @ColumnInfo(name = "Master League Score") val ratingML: Int?,
    @ColumnInfo(name = "Great League Fast Move") val fastMoveGL: List<String>?,
    @ColumnInfo(name = "Ultra League Fast Move") val fastMoveUL: List<String>?,
    @ColumnInfo(name = "Master League Fast Move") val fastMoveML: List<String>?,
    @ColumnInfo(name = "Great League Charged Moves") val chargedMovesGL: List<String>?,
    @ColumnInfo(name = "Ultra League Charged Moves") val chargedMovesUL: List<String>?,
    @ColumnInfo(name = "Master League Charged Moves") val chargedMovesML: List<String>?
)