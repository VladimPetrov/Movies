package com.example.lesson2movies.repo

import com.example.lesson2movies.domain.Movie

interface IMovieRepo {
    fun loadMovies():List<Movie>
}