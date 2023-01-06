package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.database.PreviewDao
import com.example.kplist.data.models.DbModels.PreviewDbModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(private val previewDao: PreviewDao): LocalDataSourceRepository{

    override fun insertPreview(previewModel: PreviewDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            previewDao.insertPreview(previewModel)}
    }

    override fun getAllPreview(): LiveData<List<PreviewDbModel>> {
        return previewDao.getAllPreview()
    }

    override suspend fun clearPreview() {
        CoroutineScope(Dispatchers.IO).launch {
            previewDao.clearPreview()}
    }
}