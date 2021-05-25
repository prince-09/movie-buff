package com.moneypati.moviewbuff.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;

import com.moneypati.moviewbuff.R;
import com.moneypati.moviewbuff.adapter.MovieListAdapter;
import com.moneypati.moviewbuff.model.MovieDetails;
import com.moneypati.moviewbuff.model.PopularMovies;
import com.moneypati.moviewbuff.service.APIClient;
import com.moneypati.moviewbuff.service.Credential;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView moviesRV;
    MovieListAdapter movieListAdapter;
    List<MovieDetails> movieDetailsList;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fade fade = new android.transition.Fade();
        View decor = getWindow().getDecorView();

        getWindow().setEnterTransition(fade);

        getWindow().setExitTransition(fade);
        moviesRV = findViewById(R.id.movies_rv);

        movieDetailsList = new ArrayList<>();
        movieListAdapter = new MovieListAdapter(movieDetailsList, this, MainActivity.this);
        linearLayoutManager = new LinearLayoutManager(this);
        moviesRV.setLayoutManager(linearLayoutManager);
        moviesRV.setAdapter(movieListAdapter);

        Call<PopularMovies> popularMoviesCall = APIClient.getInstance().getApi().getMoviesList(
                Credential.getAPI_KEY(),
                "en-US",
                1
        );

        popularMoviesCall.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    movieDetailsList.addAll(response.body().getMovieDetailsList());
                    movieListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PopularMovies> call, Throwable t) {

            }
        });
    }
}