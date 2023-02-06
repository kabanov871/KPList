package com.example.kplist.presentation.persons

import com.example.kplist.domain.detailsUseCase.GetPersonUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class PersonViewModelTest {

    private val getPersonUseCase = mockk<GetPersonUseCase>(relaxed = true)

    @Test
    fun getMovieTest() {

        val personViewModel = PersonViewModel(
            getPersonUseCase = getPersonUseCase)

        personViewModel.getPerson

        coVerify(exactly = 1) {
            getPersonUseCase.getPerson
        }

        confirmVerified(getPersonUseCase)
    }
}