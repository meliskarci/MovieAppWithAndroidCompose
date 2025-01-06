package com.meliskarci.movieapp.data.remote.dto

import com.meliskarci.movieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://www.omdbapi.com/?apikey=f2871f7&s=batman
    //https://www.omdbapi.com/?apikey=f2871f7&i=tt0372784
    //OMDb API: http://www.omdbapi.com/?i=tt3896198&apikey=f2871f7

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto

}