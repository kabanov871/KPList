package com.example.kplist.domain.detailsUseCase

import androidx.lifecycle.LiveData
import com.example.kplist.domain.Repository
import com.example.kplist.domain.modelsUseCase.MovieUseCaseModel
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor (private val repository: Repository) {

    fun searchMovie(movieId: String, token: String) {
        repository.searchMovie(movieId, token)
    }
}