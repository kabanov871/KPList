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
    private val mapper: Mapper,
    private val api: ApiInterface
        ): Repository{

    override fun getList(): LiveData<List<PreviewUseCaseModel>> { //genres: String, sort: String

        CoroutineScope(Dispatchers.IO).launch{

        localDataSourceRepository.clearPreview()
        remoteDataSourceRepository.startMigration()
        }

        return Transformations.map(localDataSourceRepository.getAllPreview()) {
            mapper.mapListPreviewDbModelToListPreviewUseCaseModel(it)
        }

    }

}