package com.moneypati.moviewbuff.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovies {
    @SerializedName("page")
    int page;

    @SerializedName("results")
    List<MovieDetails> movieDetailsList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieDetails> getMovieDetailsList() {
        return movieDetailsList;
    }

    public void setMovieDetailsList(List<MovieDetails> movieDetailsList) {
        this.movieDetailsList = movieDetailsList;
    }
}
