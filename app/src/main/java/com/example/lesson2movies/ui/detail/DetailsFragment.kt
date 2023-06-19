package com.example.lesson2movies.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.lesson2movies.databinding.DetailsFragmentBinding
import com.example.lesson2movies.domain.Movie

class DetailsFragment:Fragment() {
    lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBungleValues()
    }

    private fun initBungleValues() {
        arguments?.getParcelable<Movie>(BUNDLE_EXTRA)?.let { movie ->
            showMovie(movie)
        }
    }

    private fun showMovie(movie:Movie){
        with(binding) {
            movieName.text = movie.name
            genreTextView.text = movie.showGenres()
            popularityTextView.text = movie.popularity
            timeTextView.text = movie.runtime
            titleMovieTextView.text = movie.overview
            posterMovie.load(movie.getPosterUrl())
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "movies"
    }

}