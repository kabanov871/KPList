package com.example.kplist.domain.modelsUseCase

import androidx.room.ColumnInfo
import javax.inject.Inject

data class MovieUseCaseModel @Inject constructor(

    val movieId: Int,
    val poster: String? = null,
    val name: String? = null,
    val description: String? = null,
    val year: String? = null,
    val ratingKp: Double? = null,
    val ratingImdb: Double? = null,
    val ratingCritic: Double? = null
)