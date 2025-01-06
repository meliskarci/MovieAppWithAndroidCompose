package com.meliskarci.movieapp.domain.repository

import com.meliskarci.movieapp.data.remote.dto.MovieDetailDto
import com.meliskarci.movieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}