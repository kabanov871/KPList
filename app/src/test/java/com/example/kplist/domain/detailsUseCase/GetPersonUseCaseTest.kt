package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GetPersonUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getPersonTest() {

        val getPersonUseCase = GetPersonUseCase(repository = repository)

        getPersonUseCase.getPerson

        coVerify(exactly = 1) {
            repository.getPerson }

        confirmVerified(repository)

    }
}