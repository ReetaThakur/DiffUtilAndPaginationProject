package com.reeta.diffutilandpaginationproject.pagination.ui

import androidx.lifecycle.ViewModel
import com.reeta.diffutilandpaginationproject.pagination.repository.MovieRepository

class MovieViewModel():ViewModel() {

    private val respository= MovieRepository()

    fun getMovie() = respository.getPagelist()
}