package com.meliskarci.movieapp.presentation.movie_detail

import com.meliskarci.movieapp.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)