package com.example.kplist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetListUseCase @Inject constructor (private val repository: Repository) {

    fun getList(): LiveData<List<PreviewUseCaseModel>> {  //genres: String, sort: String
        return repository.getList()  //genres, sort
    }
}