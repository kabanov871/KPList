package com.example.kplist.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.dbModels.MovieDbModel

@Dao
interface MovieDao {

    @Insert
    suspend fun insertMovie(detailDbModel: MovieDbModel)

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMovie(id: Int): LiveData<MovieDbModel?>

    @Query("DELETE FROM movie_table")
    suspend fun clearMovie()
}