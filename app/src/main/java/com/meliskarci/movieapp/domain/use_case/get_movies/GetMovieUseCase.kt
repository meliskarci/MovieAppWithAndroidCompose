package com.meliskarci.movieapp.domain.use_case.get_movies

import com.meliskarci.movieapp.data.remote.dto.toMovieList
import com.meliskarci.movieapp.domain.model.Movie
import com.meliskarci.movieapp.domain.repository.MovieRepository
import com.meliskarci.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository : MovieRepository) {

    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if(movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
                }
                else {
                    emit(Resource.Error("Movie not found"))
                }

        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }
}