package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class AdvancedSearchPreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun advancedSearchPreviewTest() {

        val advancedSearchPreviewUseCase = AdvancedSearchPreviewUseCase(repository = repository)

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

        coVerify(exactly = 1) {
            repository.advancedSearchPreview(
                nameField = "nameFieldTest",
                search = "searchTest",
                nameField2 = "nameField2Test",
                search2 = "search2Test",
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest"
            ) }

        confirmVerified(repository)

    }
}