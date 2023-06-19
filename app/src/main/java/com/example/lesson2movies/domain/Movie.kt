package com.example.lesson2movies.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val name: String,
    val posterPath: String,
    val genres: List<Genre>,
    val runtime: String,
    val releaseDate: String,
    val popularity: String,
    val overview: String
):Parcelable {
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
