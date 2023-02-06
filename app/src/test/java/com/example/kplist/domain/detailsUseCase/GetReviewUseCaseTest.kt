package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GetReviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getReviewTest() {

        val getReviewUseCase = GetReviewUseCase(repository = repository)

        getReviewUseCase.getReview

        coVerify(exactly = 1) {
            repository.getReview }

        confirmVerified(repository)

    }
}