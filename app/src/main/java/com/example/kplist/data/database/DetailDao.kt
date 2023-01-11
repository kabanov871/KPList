package com.example.kplist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.DbModels.DetailDbModel

@Dao
interface DetailDao {

    @Insert
    suspend fun insertDetail(detailDbModel: DetailDbModel)

    @Query("SELECT * FROM detail_table")
    fun getAllDetail(): LiveData<List<DetailDbModel>>

    @Query("DELETE FROM detail_table")
    suspend fun clearDetail()
}