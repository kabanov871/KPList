package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class SearchReviewUseCase @Inject constructor (private val repository: Repository) {

    fun searchReview(movieId: String) {
        repository.searchReview(movieId)
    }
}