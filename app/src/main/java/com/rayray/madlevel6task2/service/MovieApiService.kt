package com.rayray.madlevel6task2.service

import com.rayray.madlevel6task2.model.Movie
import retrofit2.http.GET

interface MovieApiService {

    @GET("/3/discover/movie?api_key=4e4efe78aa0152e20bf4ca776240afb0&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    suspend fun getMovies(): Movie
}