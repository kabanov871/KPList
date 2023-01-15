package com.example.kplist.di

import android.app.Application
import com.example.kplist.presentation.facts.FactsFragment
import com.example.kplist.presentation.favorites.FavouritesFragment
import com.example.kplist.presentation.movies.MovieFragment
import com.example.kplist.presentation.persons.PersonFragment
import com.example.kplist.presentation.reviews.ReviewFragment
import com.example.kplist.presentation.search.SearchFragment
import com.example.kplist.presentation.searchByPerson.SearchByPersonFragment
import com.example.kplist.presentation.trailers.TrailerFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: SearchFragment)

    fun inject(fragment: MovieFragment)

    fun inject(fragment: FactsFragment)

    fun inject(fragment: PersonFragment)

    fun inject(fragment: ReviewFragment)

    fun inject(fragment: TrailerFragment)

    fun inject(fragment: SearchByPersonFragment)

    fun inject(fragment: FavouritesFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}