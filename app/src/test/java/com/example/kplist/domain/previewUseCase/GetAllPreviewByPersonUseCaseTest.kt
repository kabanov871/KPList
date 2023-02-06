package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GetAllPreviewByPersonUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getAllPreviewByPersonTest() {

        val getAllPreviewByPersonUseCase = GetAllPreviewByPersonUseCase(repository = repository)

        getAllPreviewByPersonUseCase.getAllPreviewByPerson

        coVerify(exactly = 1) {
            repository.allPreviewByPerson }

        confirmVerified(repository)

    }
}