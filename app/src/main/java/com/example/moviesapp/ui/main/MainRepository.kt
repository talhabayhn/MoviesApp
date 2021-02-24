package com.example.moviesapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.data.remote.ApiClient
import com.example.moviesapp.data.remote.ApiService
import com.example.moviesapp.model.movie.MovieResponse
import com.example.moviesapp.model.movie.MovieResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private val apiService: ApiService by lazy { ApiClient.getApiService() }

    fun getPopularMovies(): LiveData<List<MovieResults>>{
        val moviesLiveData: MutableLiveData<List<MovieResults>> = MutableLiveData()
        apiService.getPopularMovies().enqueue(object :Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                moviesLiveData.value= response.body()?.results
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("getPopularMovies",t.message!!) ////
            }

        })
        return moviesLiveData
    }
}