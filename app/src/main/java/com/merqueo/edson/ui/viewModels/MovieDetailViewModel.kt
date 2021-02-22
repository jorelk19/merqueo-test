package com.merqueo.edson.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.merqueo.businessModels.business.Movie
import com.merqueo.edson.ui.models.MovieModel
import com.merqueo.edson.ui.viewModels.base.BaseViewModel

class MovieDetailViewModel : BaseViewModel() {

    var movieImage = MutableLiveData<String>()
    var movieModel = MovieModel()

    /**
     * Live data to get the image movie
     * */
    fun getMovieImageLiveData(): LiveData<String> {
        return movieImage
    }

    fun setMovieData(movie : Movie){
        movie.posterPath?.let {
            movieImage.value = it
        }
        movieModel.movieDate = movie.releaseDate.toString()
        movieModel.movieName = movie.title?.let { it } ?: run { "" }
        movieModel.movieOverview = movie.overview?.let { it } ?: run { "" }
    }
}