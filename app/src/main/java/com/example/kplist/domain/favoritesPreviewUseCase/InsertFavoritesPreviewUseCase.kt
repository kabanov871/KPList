package com.example.kplist.domain.favoritesPreviewUseCase

import com.example.kplist.domain.Repository
import com.example.kplist.domain.modelsUseCase.FavoritesPreviewUseCaseModel
import javax.inject.Inject

class InsertFavoritesPreviewUseCase @Inject constructor (private val repository: Repository) {

    fun insertFavoritesPreview(movieId: Int) {
        repository.insertFavoritesPreview(movieId)
    }
}