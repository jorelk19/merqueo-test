package com.merqueo.edson.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.appbar.AppBarLayout
import com.merqueo.businessModels.business.Movie
import com.merqueo.edson.R
import com.merqueo.edson.databinding.LayoutMovieDetailFragmentBinding
import com.merqueo.edson.ui.utils.loadImage
import com.merqueo.edson.ui.viewModels.MovieDetailViewModel
import com.merqueo.edson.utils.getViewModelFactory

class MoviesDetailFragment : Fragment() {

    private lateinit var binding: LayoutMovieDetailFragmentBinding
    private val viewModel by viewModels<MovieDetailViewModel> { getViewModelFactory() }
    private var movie: Movie? = null

    companion object {
        fun getInstance(currentMovie: Movie): MoviesDetailFragment {
            val instance = MoviesDetailFragment()
            instance.setCurrentMovie(currentMovie)
            return instance
        }
    }

    private fun setCurrentMovie(currentMovie: Movie) {
        movie = currentMovie
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_movie_detail_fragment, container, false)
        binding.movieViewModel = viewModel
        loadMovieData()
        setListeners()
        addSubscription()
        return binding.root
    }

    private fun addSubscription() {
        viewModel.getMovieImageLiveData().observe(viewLifecycleOwner, Observer {
            binding.ivMovie.loadImage(it)
        })
    }

    private fun setListeners() {
        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            when {
                Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0 -> {
                    // Collapsed
                    binding.headerToolbar.visibility = View.VISIBLE
                }
                verticalOffset == 0 -> {
                    // Expanded
                    binding.headerToolbar.visibility = View.GONE
                }
                else -> {
                    // Idle
                    binding.headerToolbar.visibility = View.GONE
                }
            }
        })
    }

    private fun loadMovieData() {
        movie?.let {
            viewModel.setMovieData(it)
        }
    }
}