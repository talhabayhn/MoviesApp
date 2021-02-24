package com.example.moviesapp.ui.main.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.movie.MovieResults
import com.example.moviesapp.ui.main.MainRepository

class PopularMoviesViewModal : ViewModel() {
    private val repository: MainRepository by lazy { MainRepository() }

    fun getPopularMovies(): LiveData<List<MovieResults>>?= repository.getPopularMovies()
}