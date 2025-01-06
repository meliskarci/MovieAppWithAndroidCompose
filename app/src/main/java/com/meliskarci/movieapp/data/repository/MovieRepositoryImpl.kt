package com.meliskarci.movieapp.data.repository

import com.meliskarci.movieapp.data.remote.dto.MovieAPI
import com.meliskarci.movieapp.data.remote.dto.MovieDetailDto
import com.meliskarci.movieapp.data.remote.dto.MoviesDto
import com.meliskarci.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository{
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}

