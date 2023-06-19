package com.example.lesson2movies.utils

import com.example.lesson2movies.domain.Genre
import com.example.lesson2movies.domain.ListMovieDTO
import com.example.lesson2movies.domain.Movie
import com.example.lesson2movies.domain.MovieDTO

fun convertListDtoToListModel(listMoviesDTO: ListMovieDTO): List<Movie> {
    val fact: List<MovieDTO> = listMoviesDTO.results
    val model = mutableListOf<Movie>()
    for (movieApi in fact) {
        model.add(
            convertApiToModel(movieApi)
        )
    }
    return model

}
fun convertApiToModel(movieDto: MovieDTO): Movie {
    val popularity = movieDto.popularity ?: "0.0"
    val posterPath = movieDto.posterPath ?: ""
    return Movie(
        movieDto.id!!, movieDto.name!!, posterPath, convertGengeIds(movieDto.genres), "",
        "", popularity, ""
    )

}

fun convertGengeIds(genreIds: List<Int>): List<Genre> {
    val fact: List<Int> = genreIds
    val genre = mutableListOf<Genre>()
    var name: String
    for (idGenre in fact) {
        when (idGenre) {
            12 -> name = "приключения"
            14 -> name = "фэнтези"
            16 -> name = "мультфильм"
            18 -> name = "драма"
            27 -> name = "ужасы"
            28 -> name = "боевик"
            35 -> name = "комедия"
            36 -> name = "история"
            37 -> name = "вестерн"
            53 -> name = "триллер"
            80 -> name = "криминал"
            99 -> name = "документальный"
            878 -> name = "фантастика"
            9648 -> name = "детектив"
            10402 -> name = "музыка"
            10749 -> name = "мелодрама"
            10751 -> name = "семейный"
            10752 -> name = "военный"
            10770 -> name = "телевизионный фильм"
            else -> name = "неизвестный"
        }
        genre.add(Genre(idGenre, name))
    }
    return genre
}