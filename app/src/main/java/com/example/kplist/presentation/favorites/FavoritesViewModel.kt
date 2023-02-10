package com.example.kplist.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.favoritesPreviewUseCase.CheckFavoritesPreviewUseCase
import com.example.kplist.domain.favoritesPreviewUseCase.DeleteFavoritesPreviewUseCase
import com.example.kplist.domain.favoritesPreviewUseCase.GetAllFavoritesPreviewUseCase
import com.example.kplist.domain.favoritesPreviewUseCase.InsertFavoritesPreviewUseCase
import com.example.kplist.domain.modelsUseCase.FavoritesPreviewUseCaseModel
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    private val checkFavoritesPreviewUseCase: CheckFavoritesPreviewUseCase,
    private val deleteFavoritesPreviewUseCase: DeleteFavoritesPreviewUseCase,
    private val getAllFavoritesPreviewUseCase: GetAllFavoritesPreviewUseCase,
    private val insertFavoritesPreviewUseCase: InsertFavoritesPreviewUseCase,
) : ViewModel() {

    val getAllFavoritesPreview: LiveData<List<FavoritesPreviewUseCaseModel>>
        get() = getAllFavoritesPreviewUseCase.getAllFavoritesPreview

    fun checkFavoritesPreview(movieId: Int): Boolean {
        return checkFavoritesPreviewUseCase.checkFavoritesPreview(movieId)
    }

    fun deleteFavoritesPreview(movieId: Int) {
        deleteFavoritesPreviewUseCase.deleteFavoritesPreview(movieId)
    }

    fun insertFavoritesPreview(movieId: Int) {
        insertFavoritesPreviewUseCase.insertFavoritesPreview(movieId)
    }
}