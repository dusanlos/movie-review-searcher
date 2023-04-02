package com.example.madlevel6task2.api

import com.example.madlevel6task2.datamodel.Movie
import com.example.madlevel6task2.datamodel.MovieSearchResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/3/search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
    ): MovieSearchResult

    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Movie
}