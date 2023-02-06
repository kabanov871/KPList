package com.example.kplist.domain.favoritesUseCase

import com.example.kplist.domain.Repository
import com.example.kplist.domain.favoritesPreviewUseCase.CheckFavoritesPreviewUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class CheckFavoritesPreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun checkFavoritesPreviewTest() {

        val checkFavoritesPreviewUseCase = CheckFavoritesPreviewUseCase(repository = repository)

        checkFavoritesPreviewUseCase.checkFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            repository.checkFavoritesPreview(movieId = 1) }

        confirmVerified(repository)

    }
}