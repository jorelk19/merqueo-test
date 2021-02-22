package com.merqueo.edson.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.merqueo.businessModels.business.Movie
import com.merqueo.businessModels.result.IMovieResult
import com.merqueo.domain.MovieDomain
import com.merqueo.edson.ui.viewModels.base.BaseViewModel

class MovieViewModel(private val movieDomain: MovieDomain) : BaseViewModel() {

    var movies = MutableLiveData<ArrayList<Movie>>()
    fun getMoviesLiveData(): LiveData<ArrayList<Movie>> {
        return movies
    }

    private val movieResult = object : IMovieResult{
        override fun setMovieList(movieList: ArrayList<Movie>) {
            movies.value = movieList
        }
    }

    fun getMovies() {
        movieDomain.errorManager = this
        movieDomain.getMovies(movieResult)
    }
}