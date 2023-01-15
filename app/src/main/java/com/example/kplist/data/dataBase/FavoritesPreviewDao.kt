package com.example.kplist.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.dbModels.FavoritesPreviewDbModel

@Dao
interface FavoritesPreviewDao {

    @Insert
    suspend fun insertFavoritesPreview(favoritesPreviewModel: FavoritesPreviewDbModel)

    @Query("SELECT * FROM favorites_preview_table")
    fun getAllFavoritesPreview(): LiveData<List<FavoritesPreviewDbModel>>

    @Query("DELETE FROM favorites_preview_table WHERE movie_id = :movieId")
    suspend fun deleteFavoritesPreview(movieId: Int)

    @Query("SELECT EXISTS (SELECT 1 FROM favorites_preview_table WHERE movie_id = :movieId)")
    fun checkFavoritesPreview(movieId: Int): Boolean
}