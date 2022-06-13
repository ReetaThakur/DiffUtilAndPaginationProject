package com.reeta.diffutilandpaginationproject.pagination.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.reeta.diffutilandpaginationproject.pagination.pagingSource.MoviePagingSource

class MovieRepository {

    //our data comes here
    fun getPagelist()=Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100), // pageSize = what will our pageSize,
          pagingSourceFactory = {MoviePagingSource()}     // from where data coming,it is coming from moviePagingSource classs                                              // maxSize=  how many item later they will remove from memory
    ).liveData
}