package com.example.kplist.domain.modelsUseCase

import javax.inject.Inject

data class PreviewUseCaseModel @Inject constructor(

    val id: Int,
    val poster: String? = null,
    val name: String? = null,
    val year: String? = null,
    val ratingKp: Double? = null,
    val ratingImdb: Double? = null
)