package com.example.lesson2movies.repo.internet

import com.example.lesson2movies.BuildConfig
import com.example.lesson2movies.domain.ListMovieDTO
import com.example.lesson2movies.domain.Movie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesTMDBAPI {
    @GET("3/search/movie")

    fun loadMovie(
        @Query("api_key") apiKey : String =  BuildConfig.API_KEY,
        @Query("language") language : String = "ru-RU",
        @Query("page") page : Int = 1,
        @Query("include_adult") includeAdult : String = "false",
        @Query("query") query : String = "приключения"
    ):Single<ListMovieDTO>
}