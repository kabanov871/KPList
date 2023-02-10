package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class SearchByNamePreviewUseCase @Inject constructor(private val repository: Repository) {

    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
        repository.searchByNamePreview(
            nameField, search, isStrict, sortField, sortType, limit, token
        )
    }
}