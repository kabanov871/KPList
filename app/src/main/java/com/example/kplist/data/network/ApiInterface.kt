package com.example.kplist.data.network

import com.example.kplist.data.models.ApiPreviewModel.ApiPreviewModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("movie?field=rating.kp&limit=200&search=7-10&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06")
    suspend fun getList(): Response<ApiPreviewModel>
}

//@Query("field") genres: String, @Query("search") sort: String
//@Path("genres") genres: String, @Path("sort") sort: String
//movie?field=rating.kp&search=7-10&field=year&limit=100&search=2017-2020&field=typeNumber&search=2&sortField=year&sortType=1&sortField=votes.imdb&sortType=-1&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06