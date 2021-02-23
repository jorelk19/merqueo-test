package com.merqueo.repository

import com.merqueo.businessmodels.business.Movie
import com.merqueo.businessmodels.api.MovieApi
import com.merqueo.repository.local.LocalRepositoryManager

/**
 * Class used to manage the repository data and return correct information
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
open class RepositoryManager(private val movieApi: MovieApi, private val apiKey: String) {
    private val localRepositoryManager = LocalRepositoryManager()

    suspend fun getRemoteMovies(): ArrayList<Movie> {
        return movieApi.getMovies(apiKey = apiKey).movies
    }

    fun saveMovieLocal(movie: Movie){
        localRepositoryManager.saveMovie(movie)
    }

    fun deleteAllMoviesLocal(){
        localRepositoryManager.removeAllMovies()
    }

    fun getLocalMovies(): ArrayList<Movie> {
        return localRepositoryManager.getAllMovies()
    }
}