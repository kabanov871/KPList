package com.example.kplist.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kplist.domain.detailsUseCase.GetDetailUseCase
import com.example.kplist.domain.detailsUseCase.GetMovieUseCase
import com.example.kplist.domain.detailsUseCase.SearchMovieUseCase
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import com.example.kplist.domain.modelsUseCase.MovieUseCaseModel
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getDetailUseCase: GetDetailUseCase,
    private val searchMovieUseCase: SearchMovieUseCase
) : ViewModel() {

    fun getMovie(): LiveData<MovieUseCaseModel?> {
        return getMovieUseCase.getMovie()
    }

    fun getDetail(name: String): LiveData<List<DetailUseCaseModel>> {
        return getDetailUseCase.getDetail(name)
    }

    fun searchMovie(movieId: String, token: String) {
        searchMovieUseCase.searchMovie(movieId, token)
    }
}