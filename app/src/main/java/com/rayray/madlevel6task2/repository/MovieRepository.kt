package com.rayray.madlevel6task2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rayray.madlevel6task2.api.MovieApi
import com.rayray.madlevel6task2.model.Movie
import com.rayray.madlevel6task2.service.MovieApiService
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movie: MutableLiveData<Movie> = MutableLiveData()

    val movie: LiveData<Movie> get() = _movie

    suspend fun getMoviePoster(){
        try {
            val result = withTimeout(5_000){
                movieApiService.getMovies()
            }
            _movie.value = result
        }catch (error: Throwable){
            throw MovieRefreshError("Unable to recieve data", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}