package com.rayray.madlevel6task2.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rayray.madlevel6task2.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(application: Application): AndroidViewModel(application) {

    private val movieRepository = MovieRepository()
    val movie = movieRepository.movie
    private val _errorText: MutableLiveData<String> = MutableLiveData()

    fun getMovies(releaseYear: String){
        viewModelScope.launch {
            try {
                movieRepository.getMovies(releaseYear)
            }catch (error: MovieRepository.MovieRefreshError){
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }
}