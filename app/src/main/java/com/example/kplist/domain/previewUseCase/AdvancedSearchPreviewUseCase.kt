package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class AdvancedSearchPreviewUseCase @Inject constructor(private val repository: Repository) {

    fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
        repository.advancedSearchPreview(
            nameField, search, nameField2, search2, sortField, sortType, limit, token
        )
    }
}