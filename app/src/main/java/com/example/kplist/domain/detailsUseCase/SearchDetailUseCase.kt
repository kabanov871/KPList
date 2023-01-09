package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class SearchDetailUseCase @Inject constructor (private val repository: Repository) {

    fun searchMovie(movieId: String) {
        repository.searchMovie(movieId)
    }
}