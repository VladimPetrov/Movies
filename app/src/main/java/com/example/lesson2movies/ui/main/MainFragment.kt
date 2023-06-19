package com.example.lesson2movies.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson2movies.App
import com.example.lesson2movies.databinding.MainFragmentBinding
import com.example.lesson2movies.domain.Movie

class MainFragment:Fragment() {
    private lateinit var binding: MainFragmentBinding
    private lateinit var moviesViewModel: MoviesViewModel
    private val adapter = ListMoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        moviesViewModel.loadData()
    }

    private fun initView() {
        initRecycleView()
        showProgress(false)
    }

    private fun initRecycleView(){
        binding.mainFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.mainFragmentRecyclerView.adapter = adapter
    }
    private fun initViewModel(){
        moviesViewModel=MoviesViewModel(
            App.movieRepo
        )
        moviesViewModel.progressLiveData.observe(viewLifecycleOwner) {
            showProgress(it)
        }
        moviesViewModel.errorLiveData.observe(viewLifecycleOwner){
            showError(it)
        }
        moviesViewModel.moviesListLiveData.observe(viewLifecycleOwner) {
            showListMovie(it)
        }
    }
    private fun showListMovie(listMovies: List<Movie>) {
        adapter.setData(listMovies)
    }
    private fun showError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun showProgress(show: Boolean) {
        binding.mainFragmentLoadingLayout.isVisible = show
        binding.mainFragmentRecyclerView.isVisible = !show
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}