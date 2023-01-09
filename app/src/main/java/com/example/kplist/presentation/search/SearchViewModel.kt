package com.example.kplist.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.previewUseCase.AdvancedSearchPreviewUseCase
import com.example.kplist.domain.modelsUseCase.PreviewUseCaseModel
import com.example.kplist.domain.previewUseCase.SearchByNamePreviewUseCase
import com.example.kplist.domain.previewUseCase.GetAllPreviewUseCase
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val advancedSearchPreviewUseCase: AdvancedSearchPreviewUseCase,
    private val startingSearchPreviewUseCase: GetAllPreviewUseCase,
    private val searchByNamePreviewUseCase: SearchByNamePreviewUseCase
): ViewModel() {

    fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) { advancedSearchPreviewUseCase.advancedSearchPreview(
            nameField, search, nameField2, search2, sortField, sortType, limit, token
        )
    }

    val getAllPreview: LiveData<List<PreviewUseCaseModel>> = startingSearchPreviewUseCase.getAllPreview



    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) { searchByNamePreviewUseCase.searchByNamePreview(
            nameField, search, isStrict, sortField, sortType, limit, token)
    }
}