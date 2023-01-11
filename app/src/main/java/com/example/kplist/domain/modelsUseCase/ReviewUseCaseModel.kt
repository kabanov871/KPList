package com.example.kplist.domain.modelsUseCase

import javax.inject.Inject

data class ReviewUseCaseModel @Inject constructor (

    val review: String,

    val title: String? = null,

    val type: String? = null,

    val author: String? = null,

    val likes: Int? = null,

    val dislikes: Int? = null
)
