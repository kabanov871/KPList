package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.models.dbModels.*

interface LocalDataSourceRepository {

    suspend fun insertPreview(previewModel: PreviewDbModel)

    val allPreview: LiveData<List<PreviewDbModel>>

    suspend fun clearPreview()

    suspend fun insertFavoritesPreview(favoritesPreviewModel: FavoritesPreviewDbModel)

    val allFavoritesPreview: LiveData<List<FavoritesPreviewDbModel>>

    fun checkFavoritesPreview(movieId: Int): Boolean

    suspend fun deleteFavoritesPreview(movieId: Int)

    suspend fun insertPreviewByPerson(previewByPersonModel: PreviewByPersonDbModel)

    val allPreviewByPerson: LiveData<List<PreviewByPersonDbModel>>

    suspend fun clearPreviewByPerson()

    suspend fun insertMovie(movieModel: MovieDbModel)

    fun getMovie(id: Int): LiveData<MovieDbModel?>

    suspend fun clearMovie()

    suspend fun insertPerson(personModel: PersonDbModel)

    val allPerson: LiveData<List<PersonDbModel>>

    suspend fun clearPerson()

    suspend fun insertDetail(detailModel: DetailDbModel)

    fun getAllDetail(name: String): LiveData<List<DetailDbModel>>

    suspend fun clearDetail()

    suspend fun insertReview(reviewModel: ReviewDbModel)

    val allReview: LiveData<List<ReviewDbModel>>

    suspend fun clearReview()

}