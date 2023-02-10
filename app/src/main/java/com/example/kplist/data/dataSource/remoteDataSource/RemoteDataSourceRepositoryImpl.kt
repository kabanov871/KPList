package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import com.example.kplist.R
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.models.apiMovieModel.*
import com.example.kplist.data.models.apiPersonModel.ApiPersonModel
import com.example.kplist.data.models.apiPersonModel.Movy
import com.example.kplist.data.models.apiPreviewModel.ApiPreviewModel
import com.example.kplist.data.models.apiPreviewModel.Doc
import com.example.kplist.data.models.apiReviewModel.ApiReviewModel
import com.example.kplist.data.models.dbModels.*
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.presentation.Constance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceRepositoryImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository,
    private val api: ApiInterface,
    private val toast: Toasts,
    private val application: Application
) : RemoteDataSourceRepository {

    private lateinit var apiPersonModelBody: ApiPersonModel
    private lateinit var apiMovieModelBody: ApiMovieModel
    private lateinit var apiPreviewModelBody: ApiPreviewModel
    private lateinit var apiReviewModelBody: ApiReviewModel

    override suspend fun advancedSearchPreviewStartMigration(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
        api.advancedSearchPreview(
            nameField, search, nameField2, search2, sortField, sortType, limit, token
        ).let {
            if (it.isSuccessful) {
                withContext(Dispatchers.Main) {
                    toast.showToast(application.resources.getString(R.string.load))
                }
                if (it.body() != null) {
                    apiPreviewModelBody = it.body() as ApiPreviewModel
                    insertPreviewList(apiPreviewModelBody)
                }
            } else {
                withContext(Dispatchers.Main) {
                    toast.showToast(application.resources.getString(R.string.loadFail))
                }
            }
        }
    }

    override suspend fun searchByNamePreviewStartMigration(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    ) {
        api.searchByNamePreview(
            nameField, search, isStrict, sortField, sortType, limit, token
        ).let {
            if (it.isSuccessful) {
                withContext(Dispatchers.Main) {
                    toast.showToast(application.resources.getString(R.string.load))
                }
                if (it.body() != null) {
                    apiPreviewModelBody = it.body() as ApiPreviewModel
                    insertPreviewList(apiPreviewModelBody)
                }
            } else {
                withContext(Dispatchers.Main) {
                    toast.showToast(application.resources.getString(R.string.loadFail))
                }
            }
        }
    }

    override suspend fun getMovie(id: String, token: String) {
        api.getMovie(Constance.FIELD_BY_ID, id, token).let {
            if (it.isSuccessful) {
                if (it.body() != null) {
                    apiMovieModelBody = it.body() as ApiMovieModel
                    insertMovieModel(apiMovieModelBody)
                }
            } else {
                withContext(Dispatchers.Main) {
                    toast.showToast(application.resources.getString(R.string.loadFail))
                }
            }
        }
    }

    override suspend fun getReview(field: String, movieId: String, limit: String, token: String) {
        api.searchReview(field, movieId, limit, token).let {
            if (it.isSuccessful) {
                if (it.body() != null) {
                    apiReviewModelBody = it.body() as ApiReviewModel
                    insertReviewModel(apiReviewModelBody)
                }
            }
        }
    }

    override suspend fun insertFavoritesPreview(movieId: Int) {
        api.getMovie(Constance.FIELD_BY_ID, movieId.toString(), Constance.TOKEN).let {
            if (it.isSuccessful) {
                if (it.body() != null) {
                    apiMovieModelBody = it.body() as ApiMovieModel
                    insertFavorites(apiMovieModelBody)
                }
            } else {
                withContext(Dispatchers.Main) {
                    toast.showToast(application.resources.getString(R.string.loadFail))
                }
            }
        }
    }

    override suspend fun searchPreviewByPersonStartMigration(
        field: String,
        personId: String,
        token: String
    ) {
        api.searchReviewByPerson(field, personId, token).let {
            if (it.isSuccessful) {
                if (it.body() != null) {
                    apiPersonModelBody = it.body() as ApiPersonModel
                    insertPreviewByPerson(apiPersonModelBody)
                }
            } else withContext(Dispatchers.Main) {
                toast.showToast(application.resources.getString(R.string.loadFail))
            }
        }
    }

    suspend fun insertPreviewList(model: ApiPreviewModel) {
        val list = ArrayList<Doc>()
        list.clear()
        model.let { it1 -> list.addAll(it1.docs) }
        for (audit in list) {
            audit.id.let { it1 ->
                audit.name?.let { it2 ->
                    PreviewDbModel(
                        0,
                        it1,
                        audit.poster?.previewUrl,
                        it2,
                        audit.year.toString(),
                        audit.rating?.kp,
                        audit.rating?.imdb
                    ).let {
                        localDataSourceRepository.insertPreview(it)
                    }
                }
            }
        }
    }

    suspend fun insertMovieModel(model: ApiMovieModel) {
        val personList = ArrayList<Person>()
        val countryList = ArrayList<Country>()
        val factList = ArrayList<Fact>()
        val trailerList = ArrayList<Trailer>()
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
        personList.clear()
        model.persons?.let { it1 -> personList.addAll(it1) }
        for (audit in personList) {
            PersonDbModel(
                0,
                audit.id,
                audit.photo,
                audit.name,
                audit.enProfession
            ).let { localDataSourceRepository.insertPerson(it) }
        }
        countryList.clear()
        model.countries?.let { it1 -> countryList.addAll(it1) }
        for (audit in countryList) {
            DetailDbModel(
                0,
                R.string.detail_country.toString(),
                audit.name
            ).let { localDataSourceRepository.insertDetail(it) }
        }
        factList.clear()
        model.facts?.let { it1 -> factList.addAll(it1) }
        for (audit in factList) {
            DetailDbModel(
                0,
                R.string.detail_fact.toString(),
                audit.value
            ).let { localDataSourceRepository.insertDetail(it) }
        }
        trailerList.clear()
        model.videos?.trailers?.let { it1 -> trailerList.addAll(it1) }
        for (audit in trailerList) {
            DetailDbModel(
                0,
                R.string.detail_trailer.toString(),
                audit.url
            ).let { localDataSourceRepository.insertDetail(it) }
        }
    }

    suspend fun insertReviewModel(model: ApiReviewModel) {
        val reviewList = ArrayList<com.example.kplist.data.models.apiReviewModel.Doc>()
        reviewList.clear()
        model.docs?.let { it1 -> reviewList.addAll(it1) }
        for (audit in reviewList) {
            ReviewDbModel(
                0,
                audit.review,
                audit.title,
                audit.type,
                audit.author,
                audit.reviewLikes,
                audit.reviewDislikes
            ).let { localDataSourceRepository.insertReview(it) }
        }
    }

    suspend fun insertFavorites(model: ApiMovieModel) {
        withContext(Dispatchers.Main) {
            toast.showToast(application.resources.getString(R.string.insert_done))
        }
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

    suspend fun insertPreviewByPerson(model: ApiPersonModel) {
        val movieInPersonList = ArrayList<Movy>()
        movieInPersonList.clear()
        model.movies?.let { it1 -> movieInPersonList.addAll(it1) }
        for (audit in movieInPersonList) {
            audit.id.let {
                audit.name?.let { it2 ->
                    PreviewByPersonDbModel(
                        0,
                        audit.id,
                        it2,
                        audit.description
                    ).let {
                        localDataSourceRepository.insertPreviewByPerson(it)
                    }
                }
            }
        }
    }
}