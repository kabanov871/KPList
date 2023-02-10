package com.example.kplist.presentation.reviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.detailsUseCase.GetReviewUseCase
import com.example.kplist.domain.modelsUseCase.ReviewUseCaseModel
import javax.inject.Inject

class ReviewViewModel @Inject constructor(
    private val getReviewUseCase: GetReviewUseCase
) : ViewModel() {

    val getReview: LiveData<List<ReviewUseCaseModel>>
        get() = getReviewUseCase.getReview
}

