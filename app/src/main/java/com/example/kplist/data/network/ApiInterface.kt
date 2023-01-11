package com.example.kplist.data.network

import com.example.kplist.data.models.apiMovieModel.ApiMovieModel
import com.example.kplist.data.models.apiPreviewModel.ApiPreviewModel
import com.example.kplist.data.models.apiReviewModel.ApiReviewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie?")
    suspend fun advancedSearchPreview(
        @Query("field") nameField: String,
        @Query("search") search: String,
        @Query("field") nameField2: String,
        @Query("search") search2: String,
        @Query("sortField") sortField: String,
        @Query("sortType") sortType: String,
        @Query("limit") limit: String,
        @Query("token") token: String
    ): Response<ApiPreviewModel>

    @GET("movie?")
    suspend fun searchByNamePreview(
        @Query("field") nameField: String,
        @Query("search") search: String,
        @Query("isStrict") isStrict: Boolean,
        @Query("sortField") sortField: String,
        @Query("sortType") sortType: String,
        @Query("limit") limit: String,
        @Query("token") token: String
    ): Response<ApiPreviewModel>

    @GET("movie?")
    suspend fun getMovie(
        @Query("field") nameField: String,
        @Query("search") id: String,
        @Query("token") token: String
    ): Response<ApiMovieModel>

    @GET("review?")
    suspend fun searchReview(
        @Query("field") field: String,
        @Query("search") movieId: String,
        @Query("limit") limit: String,
        @Query("token") token: String
    ): Response<ApiReviewModel>
}


//limit=1000&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06
//field=rating.kp&search=6-10&limit=1000&
//
//@Path("genres") genres: String, @Path("sort") sort: String
//movie?field=rating.kp&search=7-10&field=year&limit=100&search=2017-2020&field=typeNumber&search=2&sortField=year&sortType=1&sortField=votes.imdb&sortType=-1&token=ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06