package com.example.kplist.domain.favoritesPreviewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class GetAllFavoritesPreviewUseCase @Inject constructor (private val repository: Repository) {

    val getAllFavoritesPreview = repository.allFavoritesPreview
}