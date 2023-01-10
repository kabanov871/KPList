package com.example.kplist.data.models.apiMovieModel

data class Videos(
    val _id: String,
    val teasers: List<Any>,
    val trailers: List<Trailer>?
)