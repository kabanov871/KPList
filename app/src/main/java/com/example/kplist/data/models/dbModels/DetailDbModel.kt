package com.example.kplist.data.models.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="detail_table")
data class DetailDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,

    val value: String? = null
        )