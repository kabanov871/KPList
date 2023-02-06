package com.example.kplist.domain.favoritesUseCase

import com.example.kplist.domain.Repository
import com.example.kplist.domain.favoritesPreviewUseCase.InsertFavoritesPreviewUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class InsertFavoritesPreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun insertFavoritesPreviewTest() {

        val insertFavoritesPreviewUseCase = InsertFavoritesPreviewUseCase(repository = repository)

        insertFavoritesPreviewUseCase.insertFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            repository.insertFavoritesPreview(movieId = 1) }

        confirmVerified(repository)

    }
}