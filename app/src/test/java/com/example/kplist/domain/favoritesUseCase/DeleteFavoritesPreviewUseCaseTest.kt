package com.example.kplist.domain.favoritesUseCase

import com.example.kplist.domain.Repository
import com.example.kplist.domain.favoritesPreviewUseCase.DeleteFavoritesPreviewUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class DeleteFavoritesPreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun deleteFavoritesPreviewTest() {

        val deleteFavoritesPreviewUseCase = DeleteFavoritesPreviewUseCase(repository = repository)

        deleteFavoritesPreviewUseCase.deleteFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            repository.deleteFavoritesPreview(movieId = 1) }

        confirmVerified(repository)

    }
}