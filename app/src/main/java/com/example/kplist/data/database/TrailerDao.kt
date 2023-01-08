package com.example.kplist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.DbModels.TrailerDbModel

@Dao
interface TrailerDao {

    @Insert
    suspend fun insertTrailer(trailerDbModel: TrailerDbModel)

    @Query("SELECT * FROM trailer_table")
    fun getAllTrailer(): LiveData<List<TrailerDbModel>>

    @Query("DELETE FROM trailer_table")
    suspend fun clearTrailer()
}