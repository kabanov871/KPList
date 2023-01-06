package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.models.DbModels.PreviewDbModel

interface LocalDataSourceRepository {

    fun insertPreview(previewModel: PreviewDbModel)

    fun getAllPreview(): LiveData<List<PreviewDbModel>>

    suspend fun clearPreview()
}