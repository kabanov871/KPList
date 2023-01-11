package com.example.kplist.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>>

    fun startingSearchPreview(
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>>

    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>>
}