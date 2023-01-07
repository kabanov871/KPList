package com.example.kplist.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.AdvancedSearchPreviewUseCase
import com.example.kplist.domain.PreviewUseCaseModel
import com.example.kplist.domain.SearchByNamePreviewUseCase
import com.example.kplist.domain.StartingSearchPreviewUseCase
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val advancedSearchPreviewUseCase: AdvancedSearchPreviewUseCase,
    private val startingSearchPreviewUseCase: StartingSearchPreviewUseCase,
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
    ):LiveData<List<PreviewUseCaseModel>> {
        return advancedSearchPreviewUseCase.advancedSearchPreview(
            nameField, search, nameField2, search2, sortField, sortType, limit, token
        )
    }

    fun startingSearchPreview(
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>> {

        return startingSearchPreviewUseCase.startingSearchPreview(
            sortField,sortType, limit, token)
    }

    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ): LiveData<List<PreviewUseCaseModel>> {

        return searchByNamePreviewUseCase.searchByNamePreview(
            nameField, search, isStrict, sortField, sortType, limit, token)
    }
}