package com.merqueo.repository

import com.merqueo.businessmodels.business.Movie

interface IRepositoryManager {
    suspend fun getRemoteMovies(): ArrayList<Movie>
    fun saveMovieLocal(movie: Movie)
    fun deleteAllMoviesLocal()
    fun getLocalMovies(): ArrayList<Movie>
}