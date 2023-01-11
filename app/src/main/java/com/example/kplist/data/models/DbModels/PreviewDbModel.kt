package com.example.kplist.data.models.DbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="preview_table")
data class PreviewDbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "movie_id")
    val movieId: Int,

    val poster: String,

    val name: String,

    val year: String,

    @ColumnInfo(name = "rating_kp")
    val ratingKp: Double,

    @ColumnInfo(name = "rating_imdb")
    val ratingImdb: Double
)
