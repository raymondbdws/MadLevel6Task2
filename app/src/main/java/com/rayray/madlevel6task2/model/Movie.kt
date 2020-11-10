package com.rayray.madlevel6task2.model

import java.time.LocalDate

data class Movie (
    var backdrop: String,
    var poster: String,
    var title: String,
    var release_date: LocalDate,
    var rating: Double,
    var overview: String
){
    fun getBackDropImage() = "https://image.tmdb.org/t/p/w500/$backdrop"
    fun getPosterImage() = "https://image.tmdb.org/t/p/w500/$poster"
}