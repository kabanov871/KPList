package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class GetReviewUseCase @Inject constructor (private val repository: Repository) {

    val getReview = repository.getReview
}