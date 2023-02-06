package com.example.kplist.domain.favoritesUseCase

import com.example.kplist.domain.Repository
import com.example.kplist.domain.favoritesPreviewUseCase.GetAllFavoritesPreviewUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GetAllFavoritesPreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getAllFavoritesPreviewTest() {

        val getAllFavoritesPreviewUseCase = GetAllFavoritesPreviewUseCase(repository = repository)

        getAllFavoritesPreviewUseCase.getAllFavoritesPreview

        coVerify(exactly = 1) {
            repository.allFavoritesPreview }

        confirmVerified(repository)

    }
}