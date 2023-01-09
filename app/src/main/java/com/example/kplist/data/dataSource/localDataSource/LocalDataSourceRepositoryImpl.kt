package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.dataBase.*
import com.example.kplist.data.models.dbModels.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val previewDao: PreviewDao,
    private val movieDao: MovieDao,
    private val personDao: PersonDao,
    private val detailDao: DetailDao
): LocalDataSourceRepository{

    override fun insertPreview(previewModel: PreviewDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            previewDao.insertPreview(previewModel)}
    }
    override val allPreview: LiveData<List<PreviewDbModel>>
        get() = previewDao.getAllPreview()

    override suspend fun clearPreview() {
        CoroutineScope(Dispatchers.IO).launch {
            previewDao.clearPreview()}
    }



    override fun insertMovie(movieModel: MovieDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.insertMovie(movieModel)}
    }
    override fun getMovie(id: Int): LiveData<MovieDbModel> {
        return movieDao.getMovie(id)}

    override suspend fun clearMovie() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.clearMovie()}
    }


    override fun insertPerson(personModel: PersonDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            personDao.insertPerson(personModel)}
    }
    override val allPerson: LiveData<List<PersonDbModel>>
        get() = personDao.getAllPerson()

    override suspend fun clearPerson() {
        CoroutineScope(Dispatchers.IO).launch {
            personDao.clearPerson()}
    }


    override fun insertDetail(detailModel: DetailDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            detailDao.insertDetail(detailModel)}
    }
    override fun getAllDetail(name: String): LiveData<List<DetailDbModel>> {
        return detailDao.getAllDetail(name)}

    override suspend fun clearDetail() {
        CoroutineScope(Dispatchers.IO).launch {
            detailDao.clearDetail()}
    }
}