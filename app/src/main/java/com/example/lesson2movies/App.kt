package com.example.lesson2movies

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.lesson2movies.repo.IMoviesRepo
import com.example.lesson2movies.repo.LocalMoviesRepo

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        var app :App? = null
        val movieRepo: IMoviesRepo = LocalMoviesRepo()
    }
}