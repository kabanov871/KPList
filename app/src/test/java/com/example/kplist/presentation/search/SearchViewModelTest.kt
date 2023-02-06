package com.example.kplist.presentation.search

import com.example.kplist.domain.detailsUseCase.SearchMovieUseCase
import com.example.kplist.domain.detailsUseCase.SearchReviewUseCase
import com.example.kplist.domain.previewUseCase.AdvancedSearchPreviewUseCase
import com.example.kplist.domain.previewUseCase.GetAllPreviewUseCase
import com.example.kplist.domain.previewUseCase.SearchByNamePreviewUseCase
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class SearchViewModelTest {

    private val advancedSearchPreviewUseCase = mockk<AdvancedSearchPreviewUseCase>(relaxed = true)
    private val getAllPreviewUseCase = mockk<GetAllPreviewUseCase>(relaxed = true)
    private val searchByNamePreviewUseCase = mockk<SearchByNamePreviewUseCase>(relaxed = true)
    private val searchMovieUseCase = mockk<SearchMovieUseCase>(relaxed = true)
    private val searchReviewUseCase = mockk<SearchReviewUseCase>(relaxed = true)

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @Test
    fun advancedSearchPreviewTest() {

        val searchViewModelTest = SearchViewModel(
            advancedSearchPreviewUseCase = advancedSearchPreviewUseCase,
            getAllPreviewUseCase = getAllPreviewUseCase,
            searchByNamePreviewUseCase = searchByNamePreviewUseCase,
            searchMovieUseCase = searchMovieUseCase,
            searchReviewUseCase = searchReviewUseCase
            )

        searchViewModelTest.advancedSearchPreview(
            nameField = "nameFieldTest",
            search = "searchTest",
            nameField2 = "nameField2Test",
            search2 = "search2Test",
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest"
        )

        coVerify(exactly = 1) {
            advancedSearchPreviewUseCase.advancedSearchPreview(
                nameField = "nameFieldTest",
                search = "searchTest",
                nameField2 = "nameField2Test",
                search2 = "search2Test",
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest"
            )
        }

        confirmVerified(
            advancedSearchPreviewUseCase,
            getAllPreviewUseCase,
            searchByNamePreviewUseCase,
            searchMovieUseCase,
            searchReviewUseCase
        )
    }

    @Test
    fun getAllPreviewTest() {

        val searchViewModelTest = SearchViewModel(
            advancedSearchPreviewUseCase = advancedSearchPreviewUseCase,
            getAllPreviewUseCase = getAllPreviewUseCase,
            searchByNamePreviewUseCase = searchByNamePreviewUseCase,
            searchMovieUseCase = searchMovieUseCase,
            searchReviewUseCase = searchReviewUseCase
        )

        searchViewModelTest.getAllPreview

        coVerify(exactly = 1) {
            getAllPreviewUseCase.getAllPreview
        }

        confirmVerified(
            advancedSearchPreviewUseCase,
            getAllPreviewUseCase,
            searchByNamePreviewUseCase,
            searchMovieUseCase,
            searchReviewUseCase
        )
    }

    @Test
    fun searchByNamePreviewTest() {

        val searchViewModelTest = SearchViewModel(
            advancedSearchPreviewUseCase = advancedSearchPreviewUseCase,
            getAllPreviewUseCase = getAllPreviewUseCase,
            searchByNamePreviewUseCase = searchByNamePreviewUseCase,
            searchMovieUseCase = searchMovieUseCase,
            searchReviewUseCase = searchReviewUseCase
        )

        searchViewModelTest.searchByNamePreview(
            nameField = "nameFieldTest",
            search = "searchTest",
            isStrict = true,
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest"
        )

        coVerify(exactly = 1) {
            searchByNamePreviewUseCase.searchByNamePreview(
                nameField = "nameFieldTest",
                search = "searchTest",
                isStrict = true,
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest"
            )
        }

        confirmVerified(
            advancedSearchPreviewUseCase,
            getAllPreviewUseCase,
            searchByNamePreviewUseCase,
            searchMovieUseCase,
            searchReviewUseCase
        )
    }

    @Test
    fun searchMovieTest() {

        val searchViewModelTest = SearchViewModel(
            advancedSearchPreviewUseCase = advancedSearchPreviewUseCase,
            getAllPreviewUseCase = getAllPreviewUseCase,
            searchByNamePreviewUseCase = searchByNamePreviewUseCase,
            searchMovieUseCase = searchMovieUseCase,
            searchReviewUseCase = searchReviewUseCase
        )

        searchViewModelTest.searchMovie(
            movieId = "movieIdTest",
            token = "tokenTest"
        )

        coVerify(exactly = 1) {
            searchMovieUseCase.searchMovie(
                movieId = "movieIdTest",
                token = "tokenTest"
            )
        }

        confirmVerified(
            advancedSearchPreviewUseCase,
            getAllPreviewUseCase,
            searchByNamePreviewUseCase,
            searchMovieUseCase,
            searchReviewUseCase
        )
    }

    @Test
    fun searchReviewTest() {

        val searchViewModelTest = SearchViewModel(
            advancedSearchPreviewUseCase = advancedSearchPreviewUseCase,
            getAllPreviewUseCase = getAllPreviewUseCase,
            searchByNamePreviewUseCase = searchByNamePreviewUseCase,
            searchMovieUseCase = searchMovieUseCase,
            searchReviewUseCase = searchReviewUseCase
        )

        searchViewModelTest.searchReview(movieId = "movieIdTest")

        coVerify(exactly = 1) {
            searchReviewUseCase.searchReview(movieId = "movieIdTest")
        }

        confirmVerified(
            advancedSearchPreviewUseCase,
            getAllPreviewUseCase,
            searchByNamePreviewUseCase,
            searchMovieUseCase,
            searchReviewUseCase
        )
    }
}