package com.example.kplist.domain

import androidx.lifecycle.LiveData
import com.example.kplist.data.models.dbModels.MovieDbModel
import com.example.kplist.domain.modelsUseCase.*

interface Repository {

    val allPreview: LiveData<List<PreviewUseCaseModel>>

    val getPerson: LiveData<List<PersonUseCaseModel>>

    val getReview: LiveData<List<ReviewUseCaseModel>>

    fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    )

    fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    )

    fun searchMovie(movieId: String, token: String)

    fun getDetail(name: String): LiveData<List<DetailUseCaseModel>>

    fun getMovie(): LiveData<MovieUseCaseModel?>

    fun searchReview(movieId: String)

}