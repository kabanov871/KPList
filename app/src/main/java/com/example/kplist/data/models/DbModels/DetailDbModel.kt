package com.example.kplist.data.models.DbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="detail_table")
data class DetailDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "movie_id")
    val movieId: Int,

    val poster: String,

    val name: String,

    val description: String,

    val year: String,

    @ColumnInfo(name = "rating_kp")
    val ratingKp: Double,

    @ColumnInfo(name = "rating_imdb")
    val ratingImdb: Double,

    @ColumnInfo(name = "rating_critic")
    val ratingCritic: Double,

    )