package com.example.kplist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.DbModels.CountryDbModel

@Dao
interface CountryDao {

    @Insert
    suspend fun insertCountry(countryDbModel: CountryDbModel)

    @Query("SELECT * FROM country_table")
    fun getAllCountry(): LiveData<List<CountryDbModel>>

    @Query("DELETE FROM country_table")
    suspend fun clearCountry()
}