package com.example.kplist.presentation.reviews

import com.example.kplist.domain.detailsUseCase.GetReviewUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class ReviewViewModelTest {

    private val getReviewUseCase = mockk<GetReviewUseCase>(relaxed = true)

    @Test
    fun getReviewTest() {

        val reviewViewModel = ReviewViewModel(
            getReviewUseCase = getReviewUseCase)

        reviewViewModel.getReview

        coVerify(exactly = 1) {
            getReviewUseCase.getReview
        }

        confirmVerified(getReviewUseCase)
    }
}