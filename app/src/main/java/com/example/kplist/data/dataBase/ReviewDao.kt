package com.example.kplist.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.dbModels.ReviewDbModel

@Dao
interface ReviewDao {

    @Insert
    suspend fun insertReview(reviewModel: ReviewDbModel)

    @Query("SELECT * FROM review_table")
    fun getAllReview(): LiveData<List<ReviewDbModel>>

    @Query("DELETE FROM review_table")
    suspend fun clearReview()
}