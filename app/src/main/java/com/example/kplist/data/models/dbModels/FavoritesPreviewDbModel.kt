package com.example.kplist.data.models.dbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="favorites_preview_table")
data class FavoritesPreviewDbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "movie_id")
    val movieId: Int,

    val poster: String? = null,

    val name: String? = null,

    val year: String? = null,

    @ColumnInfo(name = "rating_kp")
    val ratingKp: Double? = null,

    @ColumnInfo(name = "rating_imdb")
    val ratingImdb: Double? = null
)
