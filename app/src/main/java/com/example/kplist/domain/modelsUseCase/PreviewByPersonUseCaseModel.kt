package com.example.kplist.domain.modelsUseCase


import javax.inject.Inject

data class PreviewByPersonUseCaseModel @Inject constructor (

        val id: Int,

        val movieId: Int,

        val name: String? = null,

        val description: String? = null
        )
