package com.reeta.diffutilandpaginationproject.pagination.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reeta.diffutilandpaginationproject.pagination.apiCall.Network
import com.reeta.diffutilandpaginationproject.pagination.apiCall.Result
import java.lang.Exception

class MoviePagingSource:PagingSource<Int,Result>() { // int will page number and Result where our data present

    val apiCall=Network.getApiService()
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageNumber = params.key ?: 1 // first time our params can we null so we are
        // writing condition that if params will null then give pagenumber as 1
        // after first time params will have page number
        val responseDTO= apiCall.getInstance(Network.API_KEY,pageNumber) // api Call
        val movieList:List<Result> = responseDTO.results  // storing data in the list


        //LoadResult give 2 things- data and error thats why use try catch
        return try {
            //LoadResult.Page will give positive result
                //data = what is our data list
                    //prevKey= what is previous page
                        // nextKey = what will next page number
            LoadResult.Page(data = movieList,prevKey = null,
                nextKey = if (movieList.isEmpty()) null else pageNumber+1)
        }catch (e:Exception){
          LoadResult.Error(e)
        }



    }


    //introduce in pager3
    //if data get invalidated then it will give data
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }


}