package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.mapper.Mapper
import com.example.kplist.data.models.ApiPreviewModel.ApiPreviewModel
import com.example.kplist.data.models.ApiPreviewModel.Doc
import com.example.kplist.data.models.DbModels.PreviewDbModel
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.domain.PreviewUseCaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class RemoteDataSourceRepositoryImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository,
    private val api: ApiInterface,
    private val application: Application
): RemoteDataSourceRepository {

    override suspend fun advancedSearchPreviewStartMigration(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
            api.advancedSearchPreview(
                nameField, search, nameField2, search2, sortField, sortType, limit, token
            ).let {
                insertPreviewList(it)
            }
    }

    override suspend fun startingSearchPreviewStartMigration(
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
        api.startingSearchPreview(sortField, sortType, limit, token).let {
            insertPreviewList(it)
        }
    }

    override suspend fun searchByNamePreviewStartMigration(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
        api.searchByNamePreview(
            nameField, search, isStrict, sortField, sortType, limit, token
        ).let {
            insertPreviewList(it)
        }
    }

    private suspend fun insertPreviewList(it: Response<ApiPreviewModel>){

        val list = ArrayList<Doc>()

        if (it.isSuccessful) {

            withContext(Dispatchers.Main){

                Toast.makeText(application, "загрузка", Toast.LENGTH_SHORT).show()
            }

            list.clear()
            it.body()?.let { it1 -> list.addAll(it1.docs) }

            for (audit in list) {

                audit.id?.let { it1 ->
                    audit.name?.let { it2 ->
                        PreviewDbModel(
                            it1,
                            audit.poster?.previewUrl.toString(),
                            it2,
                            audit.year.toString(),
                            audit.rating.kp,
                            audit.rating.imdb
                        ).let {
                            localDataSourceRepository.insertPreview(it)
                        }
                    }
                }

            }
        }
        else {
            withContext(Dispatchers.Main){
                Toast.makeText(application, "ОШИБКА ЗАГРУЗКИ!", Toast.LENGTH_SHORT).show()}
        }
    }
}