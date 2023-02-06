package com.example.kplist.presentation.searchByPerson

import com.example.kplist.domain.previewUseCase.GetAllPreviewByPersonUseCase
import com.example.kplist.domain.previewUseCase.SearchPreviewByPersonUseCase
import com.example.kplist.presentation.search.SearchViewModel
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class SearchByPersonViewModelTest {

    private val searchPreviewByPersonUseCase = mockk<SearchPreviewByPersonUseCase>(relaxed = true)
    private val getAllPreviewByPersonUseCase = mockk<GetAllPreviewByPersonUseCase>(relaxed = true)

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @Test
    fun searchPreviewByPersonTest() {

        val searchByPersonViewModel = SearchByPersonViewModel(
            searchPreviewByPersonUseCase = searchPreviewByPersonUseCase,
            getAllPreviewByPersonUseCase = getAllPreviewByPersonUseCase
        )

        searchByPersonViewModel.searchPreviewByPerson(personId = "personIdTest")

        coVerify(exactly = 1) {
            searchPreviewByPersonUseCase.searchPreviewByPerson(personId = "personIdTest")
        }

        confirmVerified(searchPreviewByPersonUseCase, getAllPreviewByPersonUseCase)
    }

    @Test
    fun getAllPreviewByPersonTest() {

        val searchByPersonViewModel = SearchByPersonViewModel(
            searchPreviewByPersonUseCase = searchPreviewByPersonUseCase,
            getAllPreviewByPersonUseCase = getAllPreviewByPersonUseCase
        )

        searchByPersonViewModel.getAllPreviewByPerson

        coVerify(exactly = 1) {
            getAllPreviewByPersonUseCase.getAllPreviewByPerson
        }

        confirmVerified(searchPreviewByPersonUseCase, getAllPreviewByPersonUseCase)
    }
}