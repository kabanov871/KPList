package com.example.kplist.domain.modelsUseCase

import javax.inject.Inject

data class PersonUseCaseModel @Inject constructor(

    val personId: Int,
    val photo: String? = null,
    val name: String? = null,
    val prof: String? = null
)
