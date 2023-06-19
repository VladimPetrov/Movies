package com.example.lesson2movies.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson2movies.domain.Movie

class ListMoviesAdapter(val onClickItem: ((movie:Movie) -> Unit)? = null):RecyclerView.Adapter<ListMoviesViewHolder>() {
    private val data = mutableListOf<Movie>()
    fun setData(moviesList:List<Movie>){
        data.clear()
        data.addAll(moviesList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMoviesViewHolder = ListMoviesViewHolder(parent,onClickItem)

    override fun onBindViewHolder(holder: ListMoviesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}