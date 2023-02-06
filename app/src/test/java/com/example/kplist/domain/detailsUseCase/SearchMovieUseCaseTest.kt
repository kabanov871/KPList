package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class SearchMovieUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun searchMovieTest() {

        val searchMovieUseCase = SearchMovieUseCase(repository = repository)

        searchMovieUseCase.searchMovie(movieId = "movieIdTest", token = "tokenTest")

        coVerify(exactly = 1) {
            repository.searchMovie(movieId = "movieIdTest", token = "tokenTest") }

        confirmVerified(repository)

    }
}