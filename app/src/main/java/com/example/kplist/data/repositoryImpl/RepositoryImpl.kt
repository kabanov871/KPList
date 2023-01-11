package com.example.kplist.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.dataSource.remoteDataSource.RemoteDataSourceRepository
import com.example.kplist.data.mapper.Mapper
import com.example.kplist.domain.Repository
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import com.example.kplist.domain.modelsUseCase.MovieUseCaseModel
import com.example.kplist.domain.modelsUseCase.PersonUseCaseModel
import kotlinx.coroutines.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val localDataSourceRepository: LocalDataSourceRepository,
    private val remoteDataSourceRepository: RemoteDataSourceRepository,
    private val mapper: Mapper
        ): Repository{

      override fun advancedSearchPreview(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String) {
        CoroutineScope(Dispatchers.IO).launch{

          localDataSourceRepository.clearPreview()
          remoteDataSourceRepository.advancedSearchPreviewStartMigration(
            nameField, search, nameField2, search2, sortField, sortType, limit, token
          )
        }

      }

    override val allPreview = Transformations.map(localDataSourceRepository.allPreview) {
            mapper.mapListPreviewDbModelToListPreviewUseCaseModel(it)
      }

    override val getPerson = Transformations.map(localDataSourceRepository.allPerson) {
        mapper.mapListPersonDbModelToListPersonUseCaseModel(it)
    }


    override fun searchByNamePreview(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
        ) {

          CoroutineScope(Dispatchers.IO).launch{

              localDataSourceRepository.clearPreview()
              remoteDataSourceRepository.searchByNamePreviewStartMigration(
                  nameField, search, isStrict, sortField, sortType, limit, token
              )
          }
      }

    override fun searchMovie(movieId: String, token: String) {
        CoroutineScope(Dispatchers.IO).launch {

            localDataSourceRepository.clearMovie()
            localDataSourceRepository.clearDetail()
            localDataSourceRepository.clearPerson()
            remoteDataSourceRepository.getMovie(movieId, token)

        }
    }

    override fun getDetail(name: String): LiveData<List<DetailUseCaseModel>> {
        return Transformations.map(localDataSourceRepository.getAllDetail(name)) {
            mapper.mapListDetailDbModelToListDetailUseCaseModel(it)}
    }

    override fun getMovie(): LiveData<MovieUseCaseModel?> {
        return Transformations.map(localDataSourceRepository.getMovie(1)) {
            mapper.mapMovieDbModelToMovieUseCaseModel(it)}
    }




}