package com.example.kplist.presentation.searchByPerson

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.modelsUseCase.PreviewByPersonUseCaseModel
import com.example.kplist.domain.previewUseCase.GetAllPreviewByPersonUseCase
import com.example.kplist.domain.previewUseCase.SearchPreviewByPersonUseCase
import javax.inject.Inject

class SearchByPersonViewModel @Inject constructor (
    private val searchPreviewByPersonUseCase: SearchPreviewByPersonUseCase,
    private val getAllPreviewByPersonUseCase: GetAllPreviewByPersonUseCase
    ): ViewModel() {

    fun searchPreviewByPerson(personId: String) {

        searchPreviewByPersonUseCase.searchPreviewByPerson(personId)
    }

    val getAllPreviewByPerson: LiveData<List<PreviewByPersonUseCaseModel>>
        get() = getAllPreviewByPersonUseCase.getAllPreviewByPerson
}