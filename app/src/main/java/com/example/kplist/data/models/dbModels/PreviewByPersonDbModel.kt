package com.example.kplist.data.models.dbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preview_by_person_table")
data class PreviewByPersonDbModel(

        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "movie_id")
        val movieId: Int,

        val name: String? = null,

        val description: String? = null
)