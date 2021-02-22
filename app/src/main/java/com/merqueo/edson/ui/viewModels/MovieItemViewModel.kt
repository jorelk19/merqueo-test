package com.merqueo.edson.ui.viewModels

import com.merqueo.businessModels.business.Movie
import com.merqueo.edson.R
import com.merqueo.edson.ui.models.MovieItemModel
import com.merqueo.edson.ui.viewModels.base.BaseViewModel
import com.merqueo.edson.ui.views.fragments.MoviesDetailFragment
import com.merqueo.edson.utils.Navigation

/**
 * Class used to manage the view model for the movie item in recycler view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MovieItemViewModel : BaseViewModel() {
    private lateinit var currentMovie: Movie
    var movieItemModel = MovieItemModel()

    /**
     * Method used to call the fragment to show movie detail
     * */
    fun showMovieDetail() {
        if (::currentMovie.isInitialized) {
            Navigation.getInstance.attachFragment(MoviesDetailFragment.getInstance(currentMovie), R.id.fragment_container)
        }
    }

    /**
     * Method used to set the movie data
     * */
    fun setMovieData(model: Movie) {
        currentMovie = model
        model.title?.let {
            movieItemModel.movieName = it
        }
        model.posterPath?.let {
            movieItemModel.movieImage = it
        }
    }
}