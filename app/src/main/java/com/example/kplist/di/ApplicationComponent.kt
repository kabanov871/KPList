package com.example.kplist.di

import android.app.Application
import com.example.kplist.presentation.facts.FactsFragment
import com.example.kplist.presentation.movies.MovieFragment
import com.example.kplist.presentation.search.SearchFragment
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

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}