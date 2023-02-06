package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class GetDetailUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getDetailTest() {

        val getDetailUseCase = GetDetailUseCase(repository = repository)

        getDetailUseCase.getDetail(name = "test")

        coVerify(exactly = 1) {
            repository.getDetail(name = "test") }

        confirmVerified(repository)

    }
}