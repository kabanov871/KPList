package com.example.kplist.domain

import javax.inject.Inject

data class ListUseCaseModel @Inject constructor(
    val id:String,
    val poster: String,
    val name: String,
    val year: String,
    val ratingKp: String,
    val ratingImdb: String
        )