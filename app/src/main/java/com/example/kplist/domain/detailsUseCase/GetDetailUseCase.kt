package com.example.kplist.domain.detailsUseCase

import androidx.lifecycle.LiveData
import com.example.kplist.domain.Repository
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import javax.inject.Inject

class GetDetailUseCase @Inject constructor (private val repository: Repository) {

    fun getDetail(name: String): LiveData<List<DetailUseCaseModel>> {
        return repository.getDetail(name)
    }
}