package com.example.kplist.domain

import retrofit2.Response
import javax.inject.Inject

class GetListUseCase @Inject constructor (private val repository: Repository) {

    fun getList(genres: String, sort: String): List<ListUseCaseModel> {
        return repository.getList(genres, sort)
    }
}