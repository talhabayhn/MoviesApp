package com.example.moviesapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.R
import com.example.moviesapp.common.ViewPagerAdapter
import com.example.moviesapp.ui.main.popular.PopularMoviesFragment
import com.example.moviesapp.ui.main.toprated.TopRatedMoviesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupUI(){
        setSupportActionBar(main_toolbar)
        setupViewPager()
        main_tabs.setupWithViewPager(main_viewpager)
    }

    private fun setupViewPager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addFragment(PopularMoviesFragment(),"Popular")
            addFragment(TopRatedMoviesFragment(),"Top Rated")
        }
        main_viewpager.adapter= adapter
    }
}