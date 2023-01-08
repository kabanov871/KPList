package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.database.*
import com.example.kplist.data.models.DbModels.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val previewDao: PreviewDao,
    private val detailDao: DetailDao,
    private val personDao: PersonDao,
    private val trailerDao: TrailerDao,
    private val countryDao: CountryDao,
    private val factDao: FactDao,
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



    override fun insertDetail(detailModel: DetailDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            detailDao.insertDetail(detailModel)}
    }
    override val allDetail: LiveData<List<DetailDbModel>>
        get() = detailDao.getAllDetail()

    override suspend fun clearDetail() {
        CoroutineScope(Dispatchers.IO).launch {
            detailDao.clearDetail()}
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


    override fun insertTrailer(trailerModel: TrailerDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            trailerDao.insertTrailer(trailerModel)}
    }
    override val allTrailer: LiveData<List<TrailerDbModel>>
        get() = trailerDao.getAllTrailer()

    override suspend fun clearTrailer() {
        CoroutineScope(Dispatchers.IO).launch {
            trailerDao.clearTrailer()}
    }


    override fun insertCountry(countryModel: CountryDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            countryDao.insertCountry(countryModel)}
    }
    override val allCountry: LiveData<List<CountryDbModel>>
        get() = countryDao.getAllCountry()

    override suspend fun clearCountry() {
        CoroutineScope(Dispatchers.IO).launch {
            countryDao.clearCountry()}
    }


    override fun insertFact(factModel: FactDbModel) {
        CoroutineScope(Dispatchers.IO).launch {
            factDao.insertFact(factModel)}
    }
    override val allFact: LiveData<List<FactDbModel>>
        get() = factDao.getAllFact()

    override suspend fun clearFact() {
        CoroutineScope(Dispatchers.IO).launch {
            factDao.clearFact()}
    }
}