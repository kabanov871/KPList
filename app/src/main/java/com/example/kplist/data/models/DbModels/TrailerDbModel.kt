package com.example.kplist.data.models.DbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="trailer_table")
data class TrailerDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val url: String
        )