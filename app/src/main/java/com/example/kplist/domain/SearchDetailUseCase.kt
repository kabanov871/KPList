package com.example.kplist.domain

import javax.inject.Inject

class SearchDetailUseCase @Inject constructor (private val repository: Repository) {

    fun searchDetail(movieId: String) {
        repository.searchDetail(movieId)
    }
}