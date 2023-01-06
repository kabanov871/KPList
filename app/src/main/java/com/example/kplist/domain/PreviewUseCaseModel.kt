package com.example.kplist.domain

import javax.inject.Inject

data class PreviewUseCaseModel @Inject constructor(
    val id:Int,
    val poster: String,
    val name: String,
    val year: String,
    val ratingKp: Double,
    val ratingImdb: Double
        )