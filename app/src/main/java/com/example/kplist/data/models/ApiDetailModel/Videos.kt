package com.example.kplist.data.models.ApiDetailModel

data class Videos(
    val _id: String,
    val teasers: List<Any>,
    val trailers: List<Trailer>
)