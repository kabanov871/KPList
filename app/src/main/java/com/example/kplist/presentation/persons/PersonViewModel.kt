package com.example.kplist.presentation.persons

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.detailsUseCase.GetDetailUseCase
import com.example.kplist.domain.detailsUseCase.GetPersonUseCase
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import com.example.kplist.domain.modelsUseCase.PersonUseCaseModel
import com.example.kplist.domain.modelsUseCase.PreviewUseCaseModel
import com.example.kplist.domain.previewUseCase.SearchPreviewByPersonUseCase
import javax.inject.Inject

class PersonViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase
): ViewModel() {

    val getPerson: LiveData<List<PersonUseCaseModel>>
        get() = getPersonUseCase.getPerson


}