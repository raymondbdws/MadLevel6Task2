package com.rayray.madlevel6task2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Result(
    @SerializedName("results")
    var results: ArrayList<Movie>
)

@Parcelize
data class Movie (

    @SerializedName("backdrop_path")
    var backdrop: String,

    @SerializedName("poster_path")
    var poster: String,

    @SerializedName("original_title")
    var title: String,

    @SerializedName("release_date")
    var release_date: String,

    @SerializedName("vote_average")
    var rating: Double,

    @SerializedName("overview")
    var overview: String
) : Parcelable {
    fun getBackDropImage() = "https://image.tmdb.org/t/p/w500/$backdrop"
    fun getPosterImage() = "https://image.tmdb.org/t/p/w500/$poster"
}
