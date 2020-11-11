package com.rayray.madlevel6task2.api

import com.rayray.madlevel6task2.service.MovieApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {

    companion object{
        private const val baseUrl = "https://api.themoviedb.org"

        fun createApi(): MovieApiService{
            val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )).build()

            val movieApi = Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return movieApi.create(MovieApiService::class.java)
        }
    }
}