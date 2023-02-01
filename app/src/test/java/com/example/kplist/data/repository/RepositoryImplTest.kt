package com.example.kplist.data.repository

import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.dataSource.remoteDataSource.RemoteDataSourceRepository
import com.example.kplist.data.mapper.Mapper
import com.example.kplist.data.repositoryImpl.RepositoryImpl
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class RepositoryImplTest {

    val localDataSourceRepository = mockk<LocalDataSourceRepository>(relaxed = true)
    val remoteDataSourceRepository = mockk<RemoteDataSourceRepository>()
    val mapper = mockk<Mapper>()

    @AfterEach
    fun afterEach() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun advancedSearchPreviewTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        coEvery { remoteDataSourceRepository.advancedSearchPreviewStartMigration(
            nameField = "nameFieldTest",
            search = "searchTest",
            nameField2 = "nameField2Test",
            search2 = "search2Test",
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest") } just runs

        repositoryImpl.advancedSearchPreview(
            nameField = "nameFieldTest",
            search = "searchTest",
            nameField2 = "nameField2Test",
            search2 = "search2Test",
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest")

        coVerifyOrder {
            localDataSourceRepository.clearPreview()
            remoteDataSourceRepository.advancedSearchPreviewStartMigration(
                nameField = "nameFieldTest",
                search = "searchTest",
                nameField2 = "nameField2Test",
                search2 = "search2Test",
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest") }

        coVerify(exactly = 1) {
            localDataSourceRepository.clearPreview()
            remoteDataSourceRepository.advancedSearchPreviewStartMigration(
                nameField = "nameFieldTest",
                search = "searchTest",
                nameField2 = "nameField2Test",
                search2 = "search2Test",
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest") }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository, remoteDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun searchByNamePreviewTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        coEvery { remoteDataSourceRepository.searchByNamePreviewStartMigration(
            nameField = "nameFieldTest",
            search = "searchTest",
            isStrict = true,
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest") } just runs

        repositoryImpl.searchByNamePreview(
            nameField = "nameFieldTest",
            search = "searchTest",
            isStrict = true,
            sortField = "sortFieldTest",
            sortType = "sortTypeTest",
            limit = "limitTest",
            token = "tokenTest"
        )

        coVerifyOrder {
            localDataSourceRepository.clearPreview()
            remoteDataSourceRepository.searchByNamePreviewStartMigration(
                nameField = "nameFieldTest",
                search = "searchTest",
                isStrict = true,
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest") }

        coVerify(exactly = 1) {
            localDataSourceRepository.clearPreview()
            remoteDataSourceRepository.searchByNamePreviewStartMigration(
                nameField = "nameFieldTest",
                search = "searchTest",
                isStrict = true,
                sortField = "sortFieldTest",
                sortType = "sortTypeTest",
                limit = "limitTest",
                token = "tokenTest") }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository, remoteDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun searchMovieTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        coEvery { remoteDataSourceRepository.getMovie(
            id = "idTest",
            token = "tokenTest") } just runs

        repositoryImpl.searchMovie(
            movieId = "idTest",
            token = "tokenTest"
        )

        coVerifyOrder {
            localDataSourceRepository.clearMovie()
            localDataSourceRepository.clearDetail()
            localDataSourceRepository.clearPerson()
            remoteDataSourceRepository.getMovie(
                id = "idTest",
                token = "tokenTest"
            )
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.clearMovie()
            localDataSourceRepository.clearDetail()
            localDataSourceRepository.clearPerson()
            remoteDataSourceRepository.getMovie(
                id = "idTest",
                token = "tokenTest"
            )
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository, remoteDataSourceRepository)
    }

    @Test
    fun getDetailTest()  {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        repositoryImpl.getDetail("nameTest")

        coVerify(exactly = 1) {
            localDataSourceRepository.getAllDetail("nameTest")
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository)

    }

    @Test
    fun getMovieTest() {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        repositoryImpl.getMovie()

        coVerify(exactly = 1) {
            localDataSourceRepository.getMovie(1)
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun searchReviewTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        coEvery { remoteDataSourceRepository.getReview(
            any(), movieId = "movieIdTest", any(), any()) } just runs

        repositoryImpl.searchReview(movieId = "movieIdTest")

        coVerifyOrder {
            localDataSourceRepository.clearReview()
            remoteDataSourceRepository.getReview(
                field = any(),
                movieId = "movieIdTest",
                limit = any(),
                token = any()
            )
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.clearReview()
            remoteDataSourceRepository.getReview(
                field = any(),
                movieId = "movieIdTest",
                limit = any(),
                token = any()
            )
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository, remoteDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun searchPreviewByPersonTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        coEvery { remoteDataSourceRepository.searchPreviewByPersonStartMigration(
            any(), personId = "personIdTest", any()) } just runs

        repositoryImpl.searchPreviewByPerson(personId = "personIdTest")

        coVerifyOrder {
            localDataSourceRepository.clearPreviewByPerson()
            remoteDataSourceRepository.searchPreviewByPersonStartMigration(
                field = any(),
                personId = "personIdTest",
                token = any()
            )
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.clearPreviewByPerson()
            remoteDataSourceRepository.searchPreviewByPersonStartMigration(
                field = any(),
                personId = "personIdTest",
                token = any()
            )
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository, remoteDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertFavoritesPreviewTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        coEvery { remoteDataSourceRepository.insertFavoritesPreview(movieId = 1) } just runs

        repositoryImpl.insertFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            remoteDataSourceRepository.insertFavoritesPreview(movieId = 1)
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository, remoteDataSourceRepository)
    }

    @Test
    fun checkFavoritesPreviewTest() {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        repositoryImpl.checkFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            localDataSourceRepository.checkFavoritesPreview(movieId = 1)
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun deleteFavoritesPreviewTest() = runTest {

        val repositoryImpl = RepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            remoteDataSourceRepository = remoteDataSourceRepository,
            mapper = mapper
        )

        repositoryImpl.deleteFavoritesPreview(movieId = 1)

        coVerify(exactly = 1) {
            localDataSourceRepository.deleteFavoritesPreview(movieId = 1)
        }

        coVerify(exactly = 1) {
            localDataSourceRepository.allPreview
            localDataSourceRepository.allFavoritesPreview
            localDataSourceRepository.allPreviewByPerson
            localDataSourceRepository.allPerson
            localDataSourceRepository.allReview
        }

        confirmVerified(localDataSourceRepository)
    }
}