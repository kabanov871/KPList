package com.example.kplist.data.network

import com.example.kplist.data.models.ApiListModel.ApiListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("movie?{genres}{sort}&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06")
    suspend fun getList(@Path("genres") genres: String, @Path("sort") sort: String): Response<ApiListModel>
}