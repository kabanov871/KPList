package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class SearchPreviewByPersonUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun searchPreviewByPersonTest() {

        val searchPreviewByPersonUseCase = SearchPreviewByPersonUseCase(repository = repository)

        searchPreviewByPersonUseCase.searchPreviewByPerson(
            personId = "personIdTest"
        )

        coVerify(exactly = 1) {
            repository.searchPreviewByPerson(
                personId = "personIdTest"
            ) }

        confirmVerified(repository)

    }
}