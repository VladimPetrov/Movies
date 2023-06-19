package com.example.lesson2movies.domain

data class Movie(
    val id: Int = 278,
    val name: String = "Побег из Шоушенка",
    val posterPath: String = "",
    val genres: List<Genre> = (listOf(Genre(28, "Action"))),
    val runtime: String = "142 мин.",
    val releaseDate: String = "1994",
    val popularity: String = "9.1",
    val overview: String = "Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника. " +
            "Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, " +
            "царящими по обе стороны решётки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. " +
            "Но Энди, обладающий живым умом и доброй душой, находит подход как к заключённым, так и к охранникам, " +
            "добиваясь их особого к себе расположения."
) {
    fun showGenres(): String {
        var result = ""
        if (genres.isEmpty()) return result
        if (genres.count() == 1) return genres.last().name
        for (i in 0..(genres.count() - 2)) {
            result += genres.get(i).name + ", "
        }
        result += genres.last().name
        return result
    }
    fun getPosterUrl(): String {
        return "https://www.themoviedb.org/t/p/w220_and_h330_face$posterPath"
    }
}
