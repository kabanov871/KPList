package com.example.kplist.data.dataSource.remoteDataSource

import android.content.Context

interface RemoteDataSourceRepository {

    suspend fun advancedSearchPreviewStartMigration(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    )

    suspend fun searchByNamePreviewStartMigration(
        nameField: String,
        search: String,
        isStrict: Boolean,
        sortField: String,
        sortType: String,
        limit: String,
        token: String
    )

    suspend fun getMovie(id: String, token: String)

    suspend fun getReview(field: String, movieId: String, limit: String, token: String)
}