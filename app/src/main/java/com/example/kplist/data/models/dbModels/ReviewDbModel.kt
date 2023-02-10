package com.example.kplist.data.models.dbModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review_table")
data class ReviewDbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val review: String,

    val title: String? = null,

    val type: String? = null,

    val author: String? = null,

    val likes: Int? = null,

    val dislikes: Int? = null
)
