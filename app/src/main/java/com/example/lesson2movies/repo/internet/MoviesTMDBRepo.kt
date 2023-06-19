package com.example.lesson2movies.repo.internet

import com.example.lesson2movies.domain.Movie
import com.example.lesson2movies.repo.IMoviesRepo
import com.example.lesson2movies.utils.convertListDtoToListModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/"

class MoviesTMDBRepo:IMoviesRepo {

    private val movieApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
            .build()
        )
        .build()
        .create(MoviesTMDBAPI::class.java)


    override fun loadMovies(onSuccess: (List<Movie>) -> Unit, onError: ((Throwable) -> Unit)?) {
        movieApi.loadMovie().subscribeBy(
            onSuccess = { onSuccess(convertListDtoToListModel( it)) },
            onError = { onError?.invoke(it) }
        )
    }
}