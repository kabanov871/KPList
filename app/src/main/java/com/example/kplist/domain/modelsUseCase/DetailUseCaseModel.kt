package com.example.kplist.domain.modelsUseCase

import javax.inject.Inject

data class DetailUseCaseModel @Inject constructor(

    val name: String,
    val value: String? = null
)
