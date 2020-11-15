package com.rayray.madlevel6task2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rayray.madlevel6task2.api.MovieApi
import com.rayray.madlevel6task2.model.Movie
import com.rayray.madlevel6task2.model.Result
import com.rayray.madlevel6task2.service.MovieApiService
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movie: MutableLiveData<List<Movie>> = MutableLiveData()

    val movie: LiveData<List<Movie>> get() = _movie

    suspend fun getMovies(releaseYear: String){
        try {
            val result = withTimeout(10_000){
                movieApiService.getMovies(releaseYear)
            }
//            for (movie in result.results){
//                _movie.value = movie
//            }
            _movie.value = result.results
        }catch (error: Throwable){
            throw MovieRefreshError("Unable to recieve data", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}