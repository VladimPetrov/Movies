package com.example.lesson2movies.repo.internet

import com.example.lesson2movies.domain.ListMovieDTO
import com.example.lesson2movies.domain.Movie

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesTMDBAPI {
    @GET("3/search/movie")

    fun loadMovie(
        @Query("api_key") apiKey : String =  "50ae6a51b3fe6942640e00627fd99cfd",
        @Query("language") language : String = "ru-RU",
        @Query("page") page : Int = 1,
        @Query("include_adult") includeAdult : String = "false",
        @Query("query") query : String = "приключения"
    ):Single<ListMovieDTO>
}