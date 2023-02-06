package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class SearchByNamePreviewUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Test
    fun searchByNamePreviewTest() {

        val searchByNamePreviewUseCase = SearchByNamePreviewUseCase(repository = repository)

        searchByNamePreviewUseCase.searchByNamePreview(
            nameField = "nameFieldTest",
            search = "searchTest",
            isStrict = true,
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest"
        )

        coVerify(exactly = 1) {
            repository.searchByNamePreview(
                nameField = "nameFieldTest",
                search = "searchTest",
                isStrict = true,
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest"
            ) }

        confirmVerified(repository)

    }
}