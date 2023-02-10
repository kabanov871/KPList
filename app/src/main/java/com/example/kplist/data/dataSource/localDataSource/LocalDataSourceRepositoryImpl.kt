package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.dataBase.*
import com.example.kplist.data.models.dbModels.*
import kotlinx.coroutines.*
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val previewDao: PreviewDao,
    private val favoritesPreviewDao: FavoritesPreviewDao,
    private val previewByPersonDao: PreviewByPersonDao,
    private val reviewDao: ReviewDao,
    private val movieDao: MovieDao,
    private val personDao: PersonDao,
    private val detailDao: DetailDao
) : LocalDataSourceRepository {

    override suspend fun insertPreview(previewModel: PreviewDbModel) {
        previewDao.insertPreview(previewModel)
    }

    override val allPreview: LiveData<List<PreviewDbModel>>
        get() = previewDao.getAllPreview()

    override suspend fun clearPreview() {
        previewDao.clearPreview()
    }

    override suspend fun insertFavoritesPreview(favoritesPreviewModel: FavoritesPreviewDbModel) {
        favoritesPreviewDao.insertFavoritesPreview(favoritesPreviewModel)
    }

    override val allFavoritesPreview: LiveData<List<FavoritesPreviewDbModel>>
        get() = favoritesPreviewDao.getAllFavoritesPreview()

    override fun checkFavoritesPreview(movieId: Int): Boolean {
        return favoritesPreviewDao.checkFavoritesPreview(movieId)
    }

    override suspend fun deleteFavoritesPreview(movieId: Int) {
        favoritesPreviewDao.deleteFavoritesPreview(movieId)
    }

    override suspend fun insertPreviewByPerson(previewByPersonModel: PreviewByPersonDbModel) {
        previewByPersonDao.insertPreviewByPerson(previewByPersonModel)
    }

    override val allPreviewByPerson: LiveData<List<PreviewByPersonDbModel>>
        get() = previewByPersonDao.getAllPreviewByPerson()

    override suspend fun clearPreviewByPerson() {
        previewByPersonDao.clearPreviewByPerson()
    }

    override suspend fun insertMovie(movieModel: MovieDbModel) {
        movieDao.insertMovie(movieModel)
    }

    override fun getMovie(id: Int): LiveData<MovieDbModel?> {
        return movieDao.getMovie(id)
    }

    override suspend fun clearMovie() {
        movieDao.clearMovie()
    }

    override suspend fun insertPerson(personModel: PersonDbModel) {
        personDao.insertPerson(personModel)
    }

    override val allPerson: LiveData<List<PersonDbModel>>
        get() = personDao.getAllPerson()

    override suspend fun clearPerson() {
        personDao.clearPerson()
    }

    override suspend fun insertDetail(detailModel: DetailDbModel) {
        detailDao.insertDetail(detailModel)
    }

    override fun getAllDetail(name: String): LiveData<List<DetailDbModel>> {
        return detailDao.getAllDetail(name)
    }

    override suspend fun clearDetail() {
        detailDao.clearDetail()
    }

    override suspend fun insertReview(reviewModel: ReviewDbModel) {
        reviewDao.insertReview(reviewModel)
    }

    override val allReview: LiveData<List<ReviewDbModel>>
        get() = reviewDao.getAllReview()

    override suspend fun clearReview() {
        reviewDao.clearReview()
    }
}