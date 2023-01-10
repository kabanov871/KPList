package com.example.kplist.di

import androidx.lifecycle.ViewModel
import com.example.kplist.presentation.facts.FactViewModel
import com.example.kplist.presentation.movies.MovieViewModel
import com.example.kplist.presentation.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    fun bindMovieViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FactViewModel::class)
    fun bindFactViewModel(viewModel: FactViewModel): ViewModel
}