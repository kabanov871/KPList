package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class SearchReviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun searchReviewTest() {

        val searchReviewUseCase = SearchReviewUseCase(repository = repository)

        searchReviewUseCase.searchReview(movieId = "movieIdTest")

        coVerify(exactly = 1) {
            repository.searchReview(movieId = "movieIdTest") }

        confirmVerified(repository)

    }
}