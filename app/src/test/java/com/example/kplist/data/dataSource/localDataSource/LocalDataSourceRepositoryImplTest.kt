package com.example.kplist.data.dataSource.localDataSource

import com.example.kplist.data.dataBase.*
import com.example.kplist.utils.*
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class LocalDataSourceRepositoryImplTest {

    private val previewDao = mockk<PreviewDao>(relaxed = true)
    private val favoritesPreviewDao = mockk<FavoritesPreviewDao>(relaxed = true)
    private val previewByPersonDao = mockk<PreviewByPersonDao>(relaxed = true)
    private val reviewDao = mockk<ReviewDao>(relaxed = true)
    private val movieDao = mockk<MovieDao>(relaxed = true)
    private val personDao = mockk<PersonDao>(relaxed = true)
    private val detailDao = mockk<DetailDao>(relaxed = true)

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertPreviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val testPreviewModel = createPreviewDbModel()

        localDataSourceRepositoryImpl.insertPreview(testPreviewModel)

        coVerify(exactly = 1) {
            previewDao.insertPreview(testPreviewModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun clearPreviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.clearPreview()

        coVerify(exactly = 1) {
            previewDao.clearPreview() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertFavoritesPreviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val testFavoritesPreviewModel = createFavoritesPreviewDbModel()

        localDataSourceRepositoryImpl.insertFavoritesPreview(testFavoritesPreviewModel)

        coVerify(exactly = 1) {
            favoritesPreviewDao.insertFavoritesPreview(testFavoritesPreviewModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun checkFavoritesPreviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val movieId = 1

        localDataSourceRepositoryImpl.checkFavoritesPreview(movieId)

        coVerify(exactly = 1) {
            favoritesPreviewDao.checkFavoritesPreview(movieId) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun deleteFavoritesPreviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val movieId = 1

        localDataSourceRepositoryImpl.deleteFavoritesPreview(movieId)

        coVerify(exactly = 1) {
            favoritesPreviewDao.deleteFavoritesPreview(movieId) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertPreviewByPersonTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val testPreviewByPersonModel = createPreviewByPersonDbModel()

        localDataSourceRepositoryImpl.insertPreviewByPerson(testPreviewByPersonModel)

        coVerify(exactly = 1) {
            previewByPersonDao.insertPreviewByPerson(testPreviewByPersonModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun clearPreviewByPersonTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.clearPreviewByPerson()

        coVerify(exactly = 1) {
            previewByPersonDao.clearPreviewByPerson() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertMovieTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val movieModel = createMovieDbModel()

        localDataSourceRepositoryImpl.insertMovie(movieModel)

        coVerify(exactly = 1) {
            movieDao.insertMovie(movieModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val id = 1

        localDataSourceRepositoryImpl.getMovie(id)

        coVerify(exactly = 1) {
            movieDao.getMovie(id) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun clearMovieTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.clearMovie()

        coVerify(exactly = 1) {
            movieDao.clearMovie() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertPersonTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val testPersonModel = createPersonDbModel()

        localDataSourceRepositoryImpl.insertPerson(testPersonModel)

        coVerify(exactly = 1) {
            personDao.insertPerson(testPersonModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun clearPersonTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.clearPerson()

        coVerify(exactly = 1) {
            personDao.clearPerson() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertDetailTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val testDetailModel = createDetailDbModel()

        localDataSourceRepositoryImpl.insertDetail(testDetailModel)

        coVerify(exactly = 1) {
            detailDao.insertDetail(testDetailModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getAllDetailTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val name = "test"

        localDataSourceRepositoryImpl.getAllDetail(name)

        coVerify(exactly = 1) {
            detailDao.getAllDetail(name) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun clearDetailTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.clearDetail()

        coVerify(exactly = 1) {
            detailDao.clearDetail() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertReviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        val testReviewModel = createReviewDbModel()

        localDataSourceRepositoryImpl.insertReview(testReviewModel)

        coVerify(exactly = 1) {
            reviewDao.insertReview(testReviewModel) }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun clearReviewTest() = runTest {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.clearReview()

        coVerify(exactly = 1) {
            reviewDao.clearReview() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @Test
    fun allPreviewTest() {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.allPreview

        coVerify(exactly = 1) {
            previewDao.getAllPreview() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @Test
    fun allFavoritesPreviewTest() {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.allFavoritesPreview

        coVerify(exactly = 1) {
            favoritesPreviewDao.getAllFavoritesPreview() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @Test
    fun allPreviewByPersonTest() {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.allPreviewByPerson

        coVerify(exactly = 1) {
            previewByPersonDao.getAllPreviewByPerson() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @Test
    fun allPersonTest() {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.allPerson

        coVerify(exactly = 1) {
            personDao.getAllPerson() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }

    @Test
    fun allReviewTest() {

        val localDataSourceRepositoryImpl = LocalDataSourceRepositoryImpl(
            previewDao = previewDao,
            favoritesPreviewDao = favoritesPreviewDao,
            previewByPersonDao = previewByPersonDao,
            reviewDao = reviewDao,
            movieDao = movieDao,
            personDao = personDao,
            detailDao = detailDao
        )

        localDataSourceRepositoryImpl.allReview

        coVerify(exactly = 1) {
            reviewDao.getAllReview() }

        confirmVerified(previewDao, favoritesPreviewDao, previewByPersonDao,
            reviewDao, movieDao, personDao, detailDao)
    }
}