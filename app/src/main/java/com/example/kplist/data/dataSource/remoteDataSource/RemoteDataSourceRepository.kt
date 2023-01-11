package com.example.kplist.data.dataSource.remoteDataSource

import android.content.Context

interface RemoteDataSourceRepository {

    suspend fun startMigration()
}