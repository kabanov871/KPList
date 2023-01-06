package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.mapper.Mapper
import com.example.kplist.data.models.DbModels.PreviewDbModel
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.domain.PreviewUseCaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSourceRepositoryImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository,
    private val mapper: Mapper,
    private val api: ApiInterface,
    private val application: Application
): RemoteDataSourceRepository {

    override suspend fun startMigration() {

            val list = ArrayList<PreviewDbModel>()

            api.getList().let {//genres, sort

                if (it.isSuccessful) {

                    withContext(Dispatchers.Main){

                    Toast.makeText(application, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
                    }

                    list.clear()
                    list.addAll(mapper.mapListApiPreviewModelToPreviewDbModelList(it.body()!!.docs))

                    for (audit in list) {

                        PreviewDbModel(
                            audit.id,
                            audit.poster,
                            audit.name,
                            audit.year,
                            audit.ratingKp,
                            audit.ratingImdb
                        ).let {
                            localDataSourceRepository.insertPreview(it)
                        }

                    }
                }
                else {
                    withContext(Dispatchers.Main){
                    Toast.makeText(application, "ОШИБКА ЗАГРУЗКИ!", Toast.LENGTH_SHORT).show()}
                }
            }
    }
}