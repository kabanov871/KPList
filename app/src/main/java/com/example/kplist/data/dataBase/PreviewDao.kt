package com.example.kplist.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.dbModels.PreviewDbModel

@Dao
interface PreviewDao {

    @Insert
    suspend fun insertPreview(previewModel: PreviewDbModel)

    @Query("SELECT * FROM preview_table")
    fun getAllPreview(): LiveData<List<PreviewDbModel>>

    @Query("DELETE FROM preview_table")
    suspend fun clearPreview()
}