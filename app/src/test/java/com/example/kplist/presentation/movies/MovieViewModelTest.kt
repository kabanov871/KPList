package com.example.kplist.presentation.movies

import com.example.kplist.domain.detailsUseCase.GetDetailUseCase
import com.example.kplist.domain.detailsUseCase.GetMovieUseCase
import com.example.kplist.domain.detailsUseCase.SearchMovieUseCase
import com.example.kplist.presentation.facts.FactViewModel
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MovieViewModelTest {

    private val getMovieUseCase = mockk<GetMovieUseCase>(relaxed = true)
    private val getDetailUseCase = mockk<GetDetailUseCase>(relaxed = true)
    private val searchMovieUseCase = mockk<SearchMovieUseCase>(relaxed = true)

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @Test
    fun getMovieTest() {

        val movieViewModel = MovieViewModel(
            getMovieUseCase = getMovieUseCase,
            getDetailUseCase = getDetailUseCase,
            searchMovieUseCase = searchMovieUseCase)

        movieViewModel.getMovie()

        coVerify(exactly = 1) {
            getMovieUseCase.getMovie()
        }

        confirmVerified(getMovieUseCase, getDetailUseCase, searchMovieUseCase)
    }

    @Test
    fun getDetailTest() {

        val movieViewModel = MovieViewModel(
            getMovieUseCase = getMovieUseCase,
            getDetailUseCase = getDetailUseCase,
            searchMovieUseCase = searchMovieUseCase)

        movieViewModel.getDetail(name = "nameTest")

        coVerify(exactly = 1) {
            getDetailUseCase.getDetail(name = "nameTest")
        }

        confirmVerified(getMovieUseCase, getDetailUseCase, searchMovieUseCase)
    }

    @Test
    fun searchMovieTest() {

        val movieViewModel = MovieViewModel(
            getMovieUseCase = getMovieUseCase,
            getDetailUseCase = getDetailUseCase,
            searchMovieUseCase = searchMovieUseCase)

        movieViewModel.searchMovie(movieId = "movieIdTest", token = "tokenTest")

        coVerify(exactly = 1) {
            searchMovieUseCase.searchMovie(movieId = "movieIdTest", token = "tokenTest")
        }

        confirmVerified(getMovieUseCase, getDetailUseCase, searchMovieUseCase)
    }
}