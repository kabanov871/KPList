package com.example.kplist.domain.favoritesPreviewUseCase

import androidx.lifecycle.LiveData
import com.example.kplist.domain.Repository
import com.example.kplist.domain.modelsUseCase.FavoritesPreviewUseCaseModel
import javax.inject.Inject

class CheckFavoritesPreviewUseCase @Inject constructor (private val repository: Repository) {

    fun checkFavoritesPreview(movieId: Int): Boolean {

        return repository.checkFavoritesPreview(movieId)
    }
}