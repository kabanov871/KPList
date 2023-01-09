package com.example.kplist.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.dbModels.DetailDbModel

@Dao
interface DetailDao {

    @Insert
    suspend fun insertDetail(detailDbModel: DetailDbModel)

    @Query("SELECT * FROM detail_table WHERE name = :name")
    fun getAllDetail(name: String): LiveData<List<DetailDbModel>>

    @Query("DELETE FROM detail_table")
    suspend fun clearDetail()
}