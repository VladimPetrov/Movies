package com.example.lesson2movies.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lesson2movies.R
import com.example.lesson2movies.databinding.ItemMovieBinding
import com.example.lesson2movies.domain.Movie

class ListMoviesViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
) {
    private val binding = ItemMovieBinding.bind(itemView)

    fun bind(item:Movie){
        binding.itemMovieName.text = item.name
        binding.itemMovieGenre.text = item.showGenres()
        binding.itemMoviePopularity.text = item.popularity
        binding.posterMovie.load(item.getPosterUrl())
    }
}