package com.example.kplist.data.models.dbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="person_table")
data class PersonDbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "person_id")
    val personId: Int,

    val photo: String? = null,

    val name: String? = null,

    val prof: String? = null
        )