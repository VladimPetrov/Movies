package com.example.lesson2movies.domain

data class ListMovieDTO(
    val page: Int,
    val results: List<MovieDTO>
)
