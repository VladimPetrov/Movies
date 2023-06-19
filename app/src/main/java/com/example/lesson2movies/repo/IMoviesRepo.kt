package com.example.lesson2movies.repo

import com.example.lesson2movies.domain.Movie

interface IMoviesRepo {
    fun loadMovies(
        onSuccess: (List<Movie>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
}