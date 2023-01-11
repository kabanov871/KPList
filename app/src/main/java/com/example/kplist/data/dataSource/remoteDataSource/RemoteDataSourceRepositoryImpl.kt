package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import android.widget.Toast
import com.example.kplist.R
import com.example.kplist.data.dataSource.localDataSource.LocalDataSourceRepository
import com.example.kplist.data.mapper.Mapper
import com.example.kplist.data.models.apiMovieModel.Country
import com.example.kplist.data.models.apiMovieModel.Fact
import com.example.kplist.data.models.apiMovieModel.Person
import com.example.kplist.data.models.apiMovieModel.Trailer
import com.example.kplist.data.models.apiPreviewModel.ApiPreviewModel
import com.example.kplist.data.models.apiPreviewModel.Doc
import com.example.kplist.data.models.dbModels.DetailDbModel
import com.example.kplist.data.models.dbModels.MovieDbModel
import com.example.kplist.data.models.dbModels.PersonDbModel
import com.example.kplist.data.models.dbModels.PreviewDbModel
import com.example.kplist.data.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceRepositoryImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository,
    private val api: ApiInterface,
    private val application: Application,
    private val mapper: Mapper
): RemoteDataSourceRepository {

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
                insertPreviewList(it)
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
            insertPreviewList(it)
        }
    }

    override suspend fun getMovie(id: String, token: String) {

        val personList = ArrayList<Person>()
        val countryList = ArrayList<Country>()
        val factList = ArrayList<Fact>()
        val trailerList = ArrayList<Trailer>()

        api.getMovie("id", id, token).let {

            if (it.isSuccessful) {

                val response = it.body()

                if (response != null) {

                    localDataSourceRepository.insertMovie(
                        MovieDbModel(
                            1,
                            response.id,
                            response.poster?.url,
                            response.name,
                            response.description,
                            response.year.toString(),
                            response.rating?.kp,
                            response.rating?.imdb,
                            response.rating?.filmCritics
                        )
                    )

                    personList.clear()
                    response.persons?.let { it1 -> personList.addAll(it1) }

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
                    response.countries?.let { it1 -> countryList.addAll(it1) }

                    for (audit in countryList) {
                        DetailDbModel(
                            0,
                            R.string.detail_country.toString(),
                            audit.name
                        ).let { localDataSourceRepository.insertDetail(it) }
                    }

                    factList.clear()
                    response.facts?.let { it1 -> factList.addAll(it1) }

                    for (audit in factList) {
                        DetailDbModel(
                            0,
                            R.string.detail_fact.toString(),
                            audit.value
                        ).let { localDataSourceRepository.insertDetail(it) }
                    }

                    trailerList.clear()
                    response.videos?.trailers?.let { it1 -> trailerList.addAll(it1) }

                    for (audit in trailerList) {
                        DetailDbModel(
                            0,
                            R.string.detail_trailer.toString(),
                            audit.url
                        ).let { localDataSourceRepository.insertDetail(it) }
                    }

                }

            }
            else { withContext(Dispatchers.Main) {
                Toast.makeText(application,  R.string.loadFail, Toast.LENGTH_SHORT).show()}}
        }
    }

    private suspend fun insertPreviewList(it: Response<ApiPreviewModel>){

        val list = ArrayList<Doc>()

        if (it.isSuccessful) {

            withContext(Dispatchers.Main){

                Toast.makeText(application, R.string.load, Toast.LENGTH_SHORT).show()
            }

            list.clear()
            it.body()?.let { it1 -> list.addAll(it1.docs) }

            for (audit in list) {

                audit.id.let { it1 ->
                        PreviewDbModel(
                            0,
                            it1,
                            audit.poster?.previewUrl,
                            audit.name,
                            audit.year.toString(),
                            audit.rating?.kp,
                            audit.rating?.imdb
                        ).let {
                            localDataSourceRepository.insertPreview(it)
                        }
                }

            }
        }
        else {
            withContext(Dispatchers.Main) {
                 Toast.makeText(application,  R.string.loadFail, Toast.LENGTH_SHORT).show()}

        }
    }
}