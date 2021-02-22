package com.merqueo.businessModels.result

import com.merqueo.businessModels.business.Movie

interface IMovieResult {
    fun setMovieList(movieList: ArrayList<Movie>)
}