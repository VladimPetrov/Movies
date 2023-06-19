package com.example.lesson2movies.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson2movies.domain.Movie
import com.example.lesson2movies.repo.IMoviesRepo
import com.example.lesson2movies.utils.SingleEventLiveData

class MoviesViewModel(private val moviesRepo:IMoviesRepo):ViewModel() {
    val moviesListLiveData: LiveData<List<Movie>> = MutableLiveData()
    val progressLiveData: LiveData<Boolean> = MutableLiveData()
    val errorLiveData: LiveData<Throwable> = SingleEventLiveData<Throwable>()

    fun loadData(){
        progressLiveData.mutable().postValue(true)
        moviesRepo.loadMovies(onSuccess = {
            progressLiveData.mutable().postValue(false)
            moviesListLiveData.mutable().postValue(it)
        }, onError = {
            progressLiveData.mutable().postValue(false)
            errorLiveData.mutable().postValue(it)
        })
    }

    private fun <T> LiveData<T>.mutable(): MutableLiveData<T> {
        return this as? MutableLiveData<T>
            ?: throw IllegalStateException("It is not MutableLiveData o_O")
    }
}