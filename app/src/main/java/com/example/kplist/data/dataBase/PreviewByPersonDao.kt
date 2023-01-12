package com.example.kplist.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.dbModels.PreviewByPersonDbModel

@Dao
interface PreviewByPersonDao {

    @Insert
    suspend fun insertPreviewByPerson(previewByPersonModel: PreviewByPersonDbModel)

    @Query("SELECT * FROM preview_by_person_table")
    fun getAllPreviewByPerson(): LiveData<List<PreviewByPersonDbModel>>

    @Query("DELETE FROM preview_by_person_table")
    suspend fun clearPreviewByPerson()
}