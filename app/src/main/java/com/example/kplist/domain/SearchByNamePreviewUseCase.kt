package com.example.kplist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class SearchByNamePreviewUseCase @Inject constructor (private val repository: Repository) {

    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>> {

        return repository.searchByNamePreview(nameField, search, isStrict, sortField, sortType, limit, token)
    }
}