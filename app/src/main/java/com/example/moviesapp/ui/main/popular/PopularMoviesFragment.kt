package com.example.moviesapp.ui.main.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.BaseVMFragment
import com.example.moviesapp.ui.main.MovieAdapter
import com.example.moviesapp.util.gone
import com.example.moviesapp.util.visible
import kotlinx.android.synthetic.main.fragment_popular_movies.*

class PopularMoviesFragment : BaseVMFragment<PopularMoviesViewModal>(){ // no data binding

    private lateinit var  adapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular_movies,container,false)
    }

    override fun getViewModel(): Class<PopularMoviesViewModal> = PopularMoviesViewModal::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter= MovieAdapter()
        popular_recyclerview.layoutManager= GridLayoutManager(activity,2)
        viewModel.getPopularMovies()?.observe(this, Observer {
            adapter.submitList(it)
            popular_recyclerview.adapter= adapter
            popular_recyclerview.visible()
            popular_progressbar.gone()
        })
    }
}