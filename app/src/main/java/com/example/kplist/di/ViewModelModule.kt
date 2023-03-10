package com.example.kplist.di

import androidx.lifecycle.ViewModel
import com.example.kplist.presentation.facts.FactViewModel
import com.example.kplist.presentation.favorites.FavoritesViewModel
import com.example.kplist.presentation.movies.MovieViewModel
import com.example.kplist.presentation.persons.PersonViewModel
import com.example.kplist.presentation.reviews.ReviewViewModel
import com.example.kplist.presentation.search.SearchViewModel
import com.example.kplist.presentation.searchByPerson.SearchByPersonViewModel
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
    @ViewModelKey(SearchByPersonViewModel::class)
    fun bindSearchByPersonViewModel(viewModel: SearchByPersonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    fun bindMovieViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FactViewModel::class)
    fun bindFactViewModel(viewModel: FactViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonViewModel::class)
    fun bindPersonViewModel(viewModel: PersonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel::class)
    fun bindReviewViewModel(viewModel: ReviewViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    fun bindFavoritesViewModel(viewModel: FavoritesViewModel): ViewModel
}