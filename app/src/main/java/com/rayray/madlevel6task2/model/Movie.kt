package com.rayray.madlevel6task2.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Movie (

    @SerializedName("backdrop")
    var backdrop: String,

    @SerializedName("poster")
    var poster: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("release_date")
    var release_date: LocalDate,

    @SerializedName("rating")
    var rating: Double,

    @SerializedName("overview")
    var overview: String
){
    fun getBackDropImage() = "https://image.tmdb.org/t/p/w500/$backdrop"
    fun getPosterImage() = "https://image.tmdb.org/t/p/w500/$poster"
}