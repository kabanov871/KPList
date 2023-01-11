package com.example.kplist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class AdvancedSearchPreviewUseCase @Inject constructor (private val repository: Repository) {

    fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>> {

        return repository.advancedSearchPreview(
            nameField, search, nameField2, search2, sortField, sortType, limit, token
        )
    }
}