package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GetMovieUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getMovieTest() {

        val getMovieUseCase = GetMovieUseCase(repository = repository)

        getMovieUseCase.getMovie()

        coVerify(exactly = 1) {
            repository.getMovie() }

        confirmVerified(repository)

    }
}