package com.example.kplist.presentation.facts

import com.example.kplist.domain.detailsUseCase.GetDetailUseCase
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import org.junit.jupiter.api.Test

class FactViewModelTest {

    private val getDetailUseCase = mockk<GetDetailUseCase>(relaxed = true)

    @Test
    fun getDetailTest() {

        val factViewModel = FactViewModel(getDetailUseCase = getDetailUseCase)

        factViewModel.getDetail(name = "nameTest")

        coVerify(exactly = 1) {
            getDetailUseCase.getDetail(name = "nameTest")
        }

        confirmVerified(getDetailUseCase)
    }
}