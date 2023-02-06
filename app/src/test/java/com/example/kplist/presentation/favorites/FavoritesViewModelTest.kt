package com.example.kplist.presentation.favorites

import com.example.kplist.domain.favoritesPreviewUseCase.CheckFavoritesPreviewUseCase
import com.example.kplist.domain.favoritesPreviewUseCase.DeleteFavoritesPreviewUseCase
import com.example.kplist.domain.favoritesPreviewUseCase.GetAllFavoritesPreviewUseCase
import com.example.kplist.domain.favoritesPreviewUseCase.InsertFavoritesPreviewUseCase
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class FavoritesViewModelTest {

    private val checkFavoritesPreviewUseCase = mockk<CheckFavoritesPreviewUseCase>(relaxed = true)
    private val deleteFavoritesPreviewUseCase = mockk<DeleteFavoritesPreviewUseCase>(relaxed = true)
    private val getAllFavoritesPreviewUseCase = mockk<GetAllFavoritesPreviewUseCase>(relaxed = true)
    private val insertFavoritesPreviewUseCase = mockk<InsertFavoritesPreviewUseCase>(relaxed = true)

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @Test
    fun getAllFavoritesPreviewTest() {

        val favoritesViewModel = FavoritesViewModel(
            checkFavoritesPreviewUseCase = checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase = deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase = getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase = insertFavoritesPreviewUseCase
        )

        favoritesViewModel.getAllFavoritesPreview

        coVerify(exactly = 1) {
            getAllFavoritesPreviewUseCase.getAllFavoritesPreview
        }

        confirmVerified(
            checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase
        )
    }

    @Test
    fun checkFavoritesPreviewTest() {

        val favoritesViewModel = FavoritesViewModel(
            checkFavoritesPreviewUseCase = checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase = deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase = getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase = insertFavoritesPreviewUseCase
        )

        favoritesViewModel.checkFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            checkFavoritesPreviewUseCase.checkFavoritesPreview(movieId = 1)
        }

        confirmVerified(
            checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase
        )
    }

    @Test
    fun deleteFavoritesPreviewTest() {

        val favoritesViewModel = FavoritesViewModel(
            checkFavoritesPreviewUseCase = checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase = deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase = getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase = insertFavoritesPreviewUseCase
        )

        favoritesViewModel.deleteFavoritesPreview(movieId = 2)

        coVerify(exactly = 1) {
            deleteFavoritesPreviewUseCase.deleteFavoritesPreview(movieId = 2)
        }

        confirmVerified(
            checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase
        )
    }

    @Test
    fun insertFavoritesPreviewTest() {

        val favoritesViewModel = FavoritesViewModel(
            checkFavoritesPreviewUseCase = checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase = deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase = getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase = insertFavoritesPreviewUseCase
        )

        favoritesViewModel.insertFavoritesPreview(movieId = 3)

        coVerify(exactly = 1) {
            insertFavoritesPreviewUseCase.insertFavoritesPreview(movieId = 3)
        }

        confirmVerified(
            checkFavoritesPreviewUseCase,
            deleteFavoritesPreviewUseCase,
            getAllFavoritesPreviewUseCase,
            insertFavoritesPreviewUseCase
        )
    }
}