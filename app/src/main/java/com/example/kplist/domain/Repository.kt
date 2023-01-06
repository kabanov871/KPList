package com.example.kplist.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun getList(): LiveData<List<PreviewUseCaseModel>>  //genres: String, sort: String
}