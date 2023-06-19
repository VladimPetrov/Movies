package com.example.lesson2movies.domain

import com.google.gson.annotations.SerializedName

data class MovieDTO (
    val id: Int = 278,
    @SerializedName("title")
    val name: String = "Побег из Шоушенка",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("genre_ids")
    val genres: List<Int>,
    val runtime: String = "142 мин.",
    val releaseDate: String = "1994",
    @SerializedName("vote_average")
    val popularity: String = "9.1",
    val overview: String = "Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника. " +
            "Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, " +
            "царящими по обе стороны решётки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. " +
            "Но Энди, обладающий живым умом и доброй душой, находит подход как к заключённым, так и к охранникам, " +
            "добиваясь их особого к себе расположения."
)