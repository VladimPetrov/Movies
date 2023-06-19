package com.example.lesson2movies

import android.app.Application
import com.example.lesson2movies.repo.IMoviesRepo
import com.example.lesson2movies.repo.LocalMoviesRepo
import com.example.lesson2movies.repo.internet.MoviesTMDBRepo

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        var app :App? = null
        val movieRepo: IMoviesRepo = MoviesTMDBRepo() //LocalMoviesRepo()
    }
}