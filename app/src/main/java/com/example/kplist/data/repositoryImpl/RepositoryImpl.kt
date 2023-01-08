package com.example.kplist.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.dataSource.remoteDataSource.RemoteDataSourceRepository
import com.example.kplist.data.mapper.Mapper
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.domain.PreviewUseCaseModel
import com.example.kplist.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    override fun searchDetail(movieId: String) {
        TODO("Not yet implemented")
    }

}