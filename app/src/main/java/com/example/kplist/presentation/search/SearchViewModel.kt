package com.example.kplist.presentation.search

import androidx.lifecycle.ViewModel
import com.example.kplist.domain.GetListUseCase
import com.example.kplist.domain.ListUseCaseModel
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase
): ViewModel() {

    fun getStartList(genres: String, sort: String):List<ListUseCaseModel> {
        return getListUseCase.getList("", "")
    }
}