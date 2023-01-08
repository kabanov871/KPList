package com.example.kplist.data.dataSource.localDataSource

import androidx.lifecycle.LiveData
import com.example.kplist.data.models.DbModels.*

interface LocalDataSourceRepository {

    fun insertPreview(previewModel: PreviewDbModel)

    val allPreview: LiveData<List<PreviewDbModel>>

    suspend fun clearPreview()


    fun insertDetail(detailModel: DetailDbModel)

    val allDetail: LiveData<List<DetailDbModel>>

    suspend fun clearDetail()


    fun insertPerson(personModel: PersonDbModel)

    val allPerson: LiveData<List<PersonDbModel>>

    suspend fun clearPerson()


    fun insertTrailer(trailerModel: TrailerDbModel)

    val allTrailer: LiveData<List<TrailerDbModel>>

    suspend fun clearTrailer()


    fun insertCountry(countryModel: CountryDbModel)

    val allCountry: LiveData<List<CountryDbModel>>

    suspend fun clearCountry()


    fun insertFact(factModel: FactDbModel)

    val allFact: LiveData<List<FactDbModel>>

    suspend fun clearFact()
}