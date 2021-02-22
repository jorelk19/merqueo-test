package com.merqueo.repository

import com.merqueo.businessModels.api.MovieApi
import com.merqueo.businessModels.business.Movie

/**
 * Class used to manage the repository data and return correct information
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class RepositoryManager(private val movieApi: MovieApi, private val apiKey : String) {
    suspend fun getMovies() : ArrayList<Movie>{
        return movieApi.getMovies(apiKey = apiKey).movies
    }
}