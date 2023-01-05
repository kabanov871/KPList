package com.example.kplist.data.models.ApiDetailModel

data class Rating(
    val _id: String,
    val await: Int,
    val filmCritics: Double,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Int
)