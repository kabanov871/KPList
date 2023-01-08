package com.example.kplist.data.models.DbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="fact_table")
data class FactDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val fact: String

    )