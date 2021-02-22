package com.merqueo.edson.ui.views.fragments.adapters

import android.content.Context
import com.merqueo.businessModels.business.Movie
import com.merqueo.edson.R
import com.merqueo.edson.databinding.LayoutMovieItemBinding
import com.merqueo.edson.ui.utils.loadImage
import com.merqueo.edson.ui.views.fragments.MoviesDetailFragment
import com.merqueo.edson.utils.GenericAdapter
import com.merqueo.edson.utils.Navigation

class MoviesAdapter(context :Context, movies: ArrayList<Movie>) : GenericAdapter<Movie,LayoutMovieItemBinding>(context, movies) {
    override fun getLayoutResId(): Int {
        return R.layout.layout_movie_item
    }

    override fun onBindData(model: Movie, position: Int, dataBinding: LayoutMovieItemBinding) {
        model.posterPath?.let {
            dataBinding.ivMovie.loadImage(it)
        }
        dataBinding.tvMovieName.text = model.title
        setListeners(model, dataBinding)
    }

    private fun setListeners(model: Movie, dataBinding: LayoutMovieItemBinding){
        dataBinding.itemContainer.setOnClickListener {
            Navigation.getInstance.attachFragment(MoviesDetailFragment.getInstance(model), R.id.fragment_container)
        }
    }
}