package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import android.widget.Toast
import com.example.kplist.R
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.models.dbModels.*
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.presentation.Constance
import com.example.kplist.utils.apiEntitiesUtils.*
import com.example.kplist.utils.createApiReviewModel
import com.example.kplist.utils.createDoc
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Response

class RemoteDataSourceRepositoryImplTest {

    val localDataSourceRepository = mockk<LocalDataSourceRepository>(relaxed = true)
    val api = mockk<ApiInterface>(relaxed = true)
    val application = mockk<Application>(relaxed = true)
    val toast = mockk<Toasts>(relaxed = true)

    @OptIn(ExperimentalCoroutinesApi::class)
    val dispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeEach
    fun beforeEach() {
        Dispatchers.setMain(dispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterEach
    fun afterEach() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun advancedSearchPreviewStartMigrationTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        remoteDataSourceRepositoryImpl.advancedSearchPreviewStartMigration(
            nameField = "nameField",
            search = "search",
            nameField2 = "nameField2",
            search2 = "search2",
            sortField = "sortField",
            sortType = "sortType",
            limit = "limit",
            token = "token"
        )

        coVerify(exactly = 1) {
            api.advancedSearchPreview(
                nameField = "nameField",
                search = "search",
                nameField2 = "nameField2",
                search2 = "search2",
                sortField = "sortField",
                sortType = "sortType",
                limit = "limit",
                token = "token"
            )
        }

        confirmVerified(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun searchByNamePreviewStartMigrationTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        remoteDataSourceRepositoryImpl.searchByNamePreviewStartMigration(
            nameField = "nameField",
            search = "search",
            isStrict = true,
            sortField = "sortField",
            sortType = "sortType",
            limit = "limit",
            token = "token"
        )

        coVerify(exactly = 1) {
            api.searchByNamePreview(
                nameField = "nameField",
                search = "search",
                isStrict = true,
                sortField = "sortField",
                sortType = "sortType",
                limit = "limit",
                token = "token"
            )
        }

        confirmVerified(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getMovieTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        remoteDataSourceRepositoryImpl.getMovie(
            id = "id", token = "token"
        )

        coVerify(exactly = 1) {
            api.getMovie(
                Constance.FIELD_BY_ID, id = "id", token = "token"
            )
        }

        confirmVerified(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getReviewTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        remoteDataSourceRepositoryImpl.getReview(
            field = "field", movieId = "movieId", limit = "limit", token = "token"
        )

        coVerify(exactly = 1) {
            api.searchReview(
                field = "field", movieId = "movieId", limit = "limit", token = "token"
            )
        }

        confirmVerified(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertFavoritesPreviewTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        val movieId = 1

        remoteDataSourceRepositoryImpl.insertFavoritesPreview(movieId)

        coVerify(exactly = 1) {
            api.getMovie(
                Constance.FIELD_BY_ID, id = movieId.toString(), Constance.TOKEN
            )
        }

        confirmVerified(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun searchPreviewByPersonStartMigrationTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        remoteDataSourceRepositoryImpl.searchPreviewByPersonStartMigration(
            field = "field",
            personId = "personId",
            token = "token"
        )

        coVerify(exactly = 1) {
            api.searchReviewByPerson(
                field = "field",
                personId = "personId",
                token = "token"
            )
        }

        confirmVerified(api)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertReviewModelTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        val model = createDoc()

        remoteDataSourceRepositoryImpl.insertReviewModel(model = createApiReviewModel())

        coVerify(exactly = 1) {
            localDataSourceRepository.insertReview(
                ReviewDbModel(
                    0,
                     model.review,
                     model.title,
                     model.type,
                     model.author,
                     model.reviewLikes,
                     model.reviewDislikes)
            )
        }
        confirmVerified(localDataSourceRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertFavoritesTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        val model = createApiMovieModel()

            remoteDataSourceRepositoryImpl.insertFavorites(model)

        coVerify(exactly = 1) {
            localDataSourceRepository.insertFavoritesPreview(
                FavoritesPreviewDbModel(
                    0,
                    model.id,
                    model.poster?.url,
                    model.name,
                    model.year.toString(),
                    model.rating?.kp,
                    model.rating?.imdb
                )
            )
        }

        confirmVerified(localDataSourceRepository)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertPreviewByPersonTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        val model = createMovy()

        remoteDataSourceRepositoryImpl.insertPreviewByPerson(createApiPersonModel())

        coVerify(exactly = 1) {
            localDataSourceRepository.insertPreviewByPerson(
                PreviewByPersonDbModel(
                    0,
                    model.id,
                    model.name,
                    model.description
                )
            )
        }

        confirmVerified(localDataSourceRepository)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertMovieModelTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        val model = createApiMovieModel()
        val modelPerson = createPerson()
        val modelCountries = createCountry()
        val modelFacts = createFact()
        val modelVideos = createTrailer()

        remoteDataSourceRepositoryImpl.insertMovieModel(model)

        coVerify(exactly = 1) {
            localDataSourceRepository.insertMovie(
                MovieDbModel(
                    1,
                    model.id,
                    model.poster?.url,
                    model.name,
                    model.description,
                    model.year.toString(),
                    model.rating?.kp,
                    model.rating?.imdb,
                    model.rating?.filmCritics
                )
            )
            localDataSourceRepository.insertPerson(
                PersonDbModel(
                    0,
                    modelPerson.id,
                    modelPerson.photo,
                    modelPerson.name,
                    modelPerson.enProfession

                )
            )
            localDataSourceRepository.insertDetail(
                DetailDbModel(
                    0,
                    R.string.detail_country.toString(),
                    modelCountries.name
                )
            )
            localDataSourceRepository.insertDetail(
                DetailDbModel(
                    0,
                    R.string.detail_fact.toString(),
                    modelFacts.value
                )
            )
            localDataSourceRepository.insertDetail(
                DetailDbModel(
                    0,
                    R.string.detail_trailer.toString(),
                    modelVideos.url
                )
            )
        }
        confirmVerified(localDataSourceRepository)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertPreviewListTest() = runTest {

        val remoteDataSourceRepositoryImpl = RemoteDataSourceRepositoryImpl(
            localDataSourceRepository = localDataSourceRepository,
            api = api,
            application = application,
            toast = toast
        )

        val model = createDoc2()
        val modelPoster = createPoster2()
        val modelRating = createRating2()

        remoteDataSourceRepositoryImpl.insertPreviewList(createApiPreviewModel())

        coVerify(exactly = 1) {
            localDataSourceRepository.insertPreview(
                PreviewDbModel(
                    0,
                    model.id,
                    modelPoster.previewUrl,
                    model.name,
                    model.year.toString(),
                    modelRating.kp,
                    modelRating.imdb
                )
            )
        }
        confirmVerified(localDataSourceRepository)

    }
}