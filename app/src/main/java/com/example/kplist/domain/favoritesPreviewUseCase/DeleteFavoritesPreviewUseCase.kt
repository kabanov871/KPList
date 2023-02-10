package com.example.kplist.domain.favoritesPreviewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class DeleteFavoritesPreviewUseCase @Inject constructor (private val repository: Repository) {

    fun deleteFavoritesPreview(movieId: Int) {
        repository.deleteFavoritesPreview(movieId)
    }
}