package com.moneypati.moviewbuff.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moneypati.moviewbuff.R;
import com.moneypati.moviewbuff.adapter.HorizontalAdapter;
import com.moneypati.moviewbuff.model.Genre;
import com.moneypati.moviewbuff.model.MovieDetails;
import com.moneypati.moviewbuff.service.APIClient;
import com.moneypati.moviewbuff.service.Credential;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    String id;
    ImageView moviePoster;
    TextView title, description;
    List<String> genreList, langList;
    RecyclerView.LayoutManager genreLayoutManager, langLayoutManager;
    RecyclerView genre_HV, language_HV;
    HorizontalAdapter genreAdapter, langAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Fade fade = new android.transition.Fade();
        View decor = getWindow().getDecorView();

        getWindow().setEnterTransition(fade);

        getWindow().setExitTransition(fade);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        moviePoster = findViewById(R.id.movie_poster);
        genre_HV = findViewById(R.id.genre_hv);
        language_HV = findViewById(R.id.lang_hv);

        genreList = new ArrayList<>();
        langList = new ArrayList<>();

        genreLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        langLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        genre_HV.setLayoutManager(genreLayoutManager);
        language_HV.setLayoutManager(langLayoutManager);

        genreAdapter = new HorizontalAdapter(genreList, this);
        langAdapter = new HorizontalAdapter(langList, this);

        genre_HV.setAdapter(genreAdapter);
        language_HV.setAdapter(langAdapter);

        id = getIntent().getStringExtra("id");

        Call<MovieDetails> movieDetailsCall = APIClient.getInstance().getApi().getMovieDetails(
                id,
                Credential.getAPI_KEY(),
                "en-US"
        );
        movieDetailsCall.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                Log.i("mov",response.isSuccessful()+"");
                if(response.isSuccessful() && response.body()!=null){
                    title.setText(response.body().getTitle());
                    description.setText(response.body().getDescription());
                    Glide.with(getApplicationContext()).load("http://image.tmdb.org/t/p/original" + response.body().getPosterPath()).into(moviePoster);
                    for (Genre genre : response.body().getGenreList()){
                        genreList.add(genre.getName());
                    }

                    genreAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {

            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            moviePoster.setAdjustViewBounds(true);
        } else {
            moviePoster.setAdjustViewBounds(true);
        }
    }
}