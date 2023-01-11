package com.example.kplist.domain.detailsUseCase

import androidx.lifecycle.LiveData
import com.example.kplist.data.models.dbModels.MovieDbModel
import com.example.kplist.domain.Repository
import com.example.kplist.domain.modelsUseCase.MovieUseCaseModel
import javax.inject.Inject

class GetMovieUseCase @Inject constructor (private val repository: Repository) {

    fun getMovie(): LiveData<MovieUseCaseModel?> {
        return repository.getMovie()
    }
}