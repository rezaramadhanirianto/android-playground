package com.example.experimental.singleActivity.modules.list.data.remote.service

import com.example.experimental.singleActivity.data.common.models.Movie
import com.example.experimental.singleActivity.data.common.remote.Responses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String, @Query("page") page: Long
    ): Response<Responses<Movie>>
}