package com.rayray.madlevel6task2.service

import com.rayray.madlevel6task2.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/3/discover/movie?api_key=4e4efe78aa0152e20bf4ca776240afb0&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&with_original_language=en&page=1")
    suspend fun getMovies(@Query("year") year: String): Result
}