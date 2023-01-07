package com.example.kplist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class StartingSearchPreviewUseCase @Inject constructor (private val repository: Repository) {

    fun startingSearchPreview(
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>> {

        return repository.startingSearchPreview(sortField, sortType, limit, token)
    }
}