package com.moneypati.moviewbuff.service;

import com.moneypati.moviewbuff.model.MovieDetails;
import com.moneypati.moviewbuff.model.PopularMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIServices {
    @GET("movie/popular")
    Call<PopularMovies> getMoviesList(
        @Query("api_key") String API_KEY,
        @Query("language") String language,
        @Query("page") int page
    );

    @GET("movie/{movie_id}")
    Call<MovieDetails> getMovieDetails(
        @Path("movie_id") String movieId,
        @Query("api_key") String API_KEY,
        @Query("language") String language
    );
}
