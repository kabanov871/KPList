package com.example.kplist.data.models.DbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="country_table")
data class CountryDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String

    )