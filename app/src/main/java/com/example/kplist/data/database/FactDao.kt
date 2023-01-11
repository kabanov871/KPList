package com.example.kplist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.DbModels.FactDbModel

@Dao
interface FactDao {

    @Insert
    suspend fun insertFact(factDbModel: FactDbModel)

    @Query("SELECT * FROM fact_table")
    fun getAllFact(): LiveData<List<FactDbModel>>

    @Query("DELETE FROM fact_table")
    suspend fun clearFact()
}