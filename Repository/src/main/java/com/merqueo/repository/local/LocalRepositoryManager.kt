package com.merqueo.repository.local

import com.merqueo.businessmodels.business.Movie
import com.merqueo.repository.local.entities.MovieDTO
import com.merqueo.repository.local.mapper.LocalRepositoryMapper
import io.realm.Realm

class LocalRepositoryManager() {
    private var realm: Realm = Realm.getDefaultInstance()

    fun saveMovie(movie: Movie){
        val index = realm.where(MovieDTO::class.java).max("_id")
        val movieDto = LocalRepositoryMapper.mapMovieDTO(movie)
        index?.let { num ->
            movieDto.id = num.toInt() + 1
        } ?: run { movieDto.id = 1 }

        realm.executeTransaction { currentRealm ->
            currentRealm.copyToRealm(movieDto)
        }
    }

    fun updateMovie(){
    }

    fun deleteMovie(){
    }

    fun getMovie(){
    }

    fun removeAllMovies(){
        val movieDTO = realm.where(MovieDTO::class.java).findAll()
        realm.executeTransaction {
            movieDTO.deleteAllFromRealm()
        }
    }

    fun getAllMovies() : ArrayList<Movie>{
        val movies = ArrayList<Movie>()
        val moviesDto = realm.where(MovieDTO::class.java).findAll()
        moviesDto?.let { movieDTOResults ->
            movieDTOResults.forEach {
                movies.add(LocalRepositoryMapper.mapMovieBusiness(it))
            }
        }
        return  movies
    }
}
