package com.example.kplist.domain

import androidx.lifecycle.LiveData
import com.example.kplist.domain.modelsUseCase.PreviewUseCaseModel

interface Repository {

    val allPreview: LiveData<List<PreviewUseCaseModel>>

    fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    )

    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    )

    fun searchMovie(movieId: String)
}