package com.example.lesson2movies

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.lesson2movies.repo.IMovieRepo
import com.example.lesson2movies.repo.LocalMovieRepo

class App {
    val movieRepo : IMovieRepo = LocalMovieRepo()
}
val Context.app: App get() = applicationContext as App
val Fragment.app: App get() = requireContext() as App