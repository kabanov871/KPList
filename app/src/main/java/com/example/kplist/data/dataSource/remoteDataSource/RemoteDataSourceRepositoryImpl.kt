package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import android.widget.Toast
import com.example.kplist.R
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.models.apiPreviewModel.ApiPreviewModel
import com.example.kplist.data.models.apiPreviewModel.Doc
import com.example.kplist.data.models.dbModels.PreviewDbModel
import com.example.kplist.data.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
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

                Toast.makeText(application, R.string.load, Toast.LENGTH_SHORT).show()
            }

            list.clear()
            it.body()?.let { it1 -> list.addAll(it1.docs) }

            for (audit in list) {

                audit.id?.let { it1 ->
                    audit.name?.let { it2 ->
                        PreviewDbModel(
                            0,
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
            withContext(Dispatchers.Main) {
                 Toast.makeText(application,  R.string.loadFail, Toast.LENGTH_SHORT).show()}

        }
    }
}