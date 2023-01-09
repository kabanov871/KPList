package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.models.dbModels.*

interface LocalDataSourceRepository {

    fun insertPreview(previewModel: PreviewDbModel)

    val allPreview: LiveData<List<PreviewDbModel>>

    suspend fun clearPreview()


    fun insertMovie(movieModel: MovieDbModel)

    fun getMovie(id: Int): LiveData<MovieDbModel>

    suspend fun clearMovie()


    fun insertPerson(personModel: PersonDbModel)

    val allPerson: LiveData<List<PersonDbModel>>

    suspend fun clearPerson()


    fun insertDetail(detailModel: DetailDbModel)

    fun getAllDetail(name: String): LiveData<List<DetailDbModel>>

    suspend fun clearDetail()

}