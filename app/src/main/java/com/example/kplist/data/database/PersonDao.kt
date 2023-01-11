package com.example.kplist.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kplist.data.models.DbModels.PersonDbModel

@Dao
interface PersonDao {

    @Insert
    suspend fun insertPerson(personDbModel: PersonDbModel)

    @Query("SELECT * FROM person_table")
    fun getAllPerson(): LiveData<List<PersonDbModel>>

    @Query("DELETE FROM person_table")
    suspend fun clearPerson()
}