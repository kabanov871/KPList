package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GetAllPreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun getAllPreviewTest() {

        val getAllPreviewUseCase = GetAllPreviewUseCase(repository = repository)

        getAllPreviewUseCase.getAllPreview

        coVerify(exactly = 1) {
            repository.allPreview }

        confirmVerified(repository)

    }
}