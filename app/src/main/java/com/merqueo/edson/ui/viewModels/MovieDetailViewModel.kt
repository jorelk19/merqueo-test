package com.merqueo.edson.ui.viewModels

import com.merqueo.businessModels.business.Movie
import com.merqueo.edson.ui.models.MovieModel
import com.merqueo.edson.ui.viewModels.base.BaseViewModel

/**
 * Class used to manage the view model for the movie detail view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MovieDetailViewModel : BaseViewModel() {

    var movieModel = MovieModel()

    /**
     * Method to set the movie values
     * */
    fun setMovieData(movie: Movie) {
        movieModel.movieDate = movie.releaseDate.toString()
        movieModel.movieName = movie.title?.let { it } ?: run { "" }
        movieModel.movieOverview = movie.overview?.let { it } ?: run { "" }
        movieModel.movieImage = movie.posterPath?.let { it } ?: run { "" }
    }
}