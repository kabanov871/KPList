package com.example.kplist.presentation.facts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.detailsUseCase.GetDetailUseCase
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import javax.inject.Inject

class FactViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase
) : ViewModel() {

    fun getDetail(name: String): LiveData<List<DetailUseCaseModel>> {
        return getDetailUseCase.getDetail(name)
    }
}