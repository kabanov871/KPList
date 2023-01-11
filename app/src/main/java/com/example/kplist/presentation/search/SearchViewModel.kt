package com.example.kplist.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.GetListUseCase
import com.example.kplist.domain.PreviewUseCaseModel
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase
): ViewModel() {

    fun getStartList():LiveData<List<PreviewUseCaseModel>> {  //genres: String, sort: String
        return getListUseCase.getList()  //genres, sort
    }
}