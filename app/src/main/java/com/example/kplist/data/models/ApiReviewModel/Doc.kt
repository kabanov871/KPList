package com.example.kplist.data.models.ApiReviewModel

data class Doc(
    val __v: Int,
    val _id: String,
    val author: String,
    val authorId: Int,
    val date: String,
    val id: Int,
    val movieId: Int,
    val review: String,
    val reviewDislikes: Int,
    val reviewLikes: Int,
    val title: String,
    val type: String,
    val updatedAt: String,
    val userRating: Int
)