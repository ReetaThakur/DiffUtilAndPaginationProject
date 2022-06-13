package com.reeta.diffutilandpaginationproject.pagination.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.diffutilandpaginationproject.R
import kotlinx.android.synthetic.main.activity_pagination.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaginationActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagination)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        setAdapter()
        viewModel.getMovie().observe(this,{
            it?.let {
                CoroutineScope(Dispatchers.Main).launch {
                    movieAdapter.submitData(it) //submitData will give data to adapter
                }
            }
        })

    }

    private fun setAdapter() {
        movieAdapter = MovieAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapter
        }
    }
}