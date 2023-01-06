package com.example.kplist.di

import android.app.Application
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepositoryImpl
import com.example.kplist.data.dataSource.remoteDataSource.RemoteDataSourceRepository
import com.example.kplist.data.dataSource.remoteDataSource.RemoteDataSourceRepositoryImpl
import com.example.kplist.data.database.KpDatabase
import com.example.kplist.data.database.PreviewDao
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.data.repositoryImpl.RepositoryImpl
import com.example.kplist.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    @Binds
    @ApplicationScope
    fun bindRemoteDataSourceRepository(impl: RemoteDataSourceRepositoryImpl): RemoteDataSourceRepository

    @Binds
    @ApplicationScope
    fun bindLocalDataSourceRepository(impl: LocalDataSourceRepositoryImpl): LocalDataSourceRepository

    companion object {

        @Provides
        @ApplicationScope
        fun providePreviewDao(application: Application): PreviewDao {
            return KpDatabase.getInstance(application).PreviewDAO
        }

        @Provides
        fun baseUrl() = "https://api.kinopoisk.dev/"

        @Provides
        @ApplicationScope
        fun provideRetrofit(baseUrl: String): ApiInterface =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
    }
}