package com.merqueo.businessmodels.api

import com.merqueo.businessmodels.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface used to get the movies from the given api
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
interface MovieApi {
    @GET("/4/list/1")
    suspend fun getMovies(@Query("api_key") apiKey: String): MovieResponse
}