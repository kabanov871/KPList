package com.example.kplist.domain

import retrofit2.Response

interface Repository {

    fun getList(genres: String, sort: String): List<ListUseCaseModel>
}