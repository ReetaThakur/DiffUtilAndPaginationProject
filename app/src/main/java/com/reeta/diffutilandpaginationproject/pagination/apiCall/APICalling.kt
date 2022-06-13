package com.reeta.diffutilandpaginationproject.pagination.apiCall

import retrofit2.http.GET
import retrofit2.http.Query

interface APICalling {

    @GET("3/movie/popular")
    suspend fun getInstance(@Query("api_key") key: String,
                            @Query("page")page:Int):ResponseDTO

}