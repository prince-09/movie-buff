package com.moneypati.moviewbuff.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.moneypati.moviewbuff.R;
import com.moneypati.moviewbuff.activity.MainActivity;
import com.moneypati.moviewbuff.activity.MovieActivity;
import com.moneypati.moviewbuff.model.MovieDetails;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyItem> {

    List<MovieDetails> movieDetailsList;
    Context context;
    Activity activity;

    public MovieListAdapter(List<MovieDetails> movieDetailsList, Context context, Activity activity) {
        this.movieDetailsList = movieDetailsList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        return new MyItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItem holder, int position) {
        MovieDetails movieDetails = movieDetailsList.get(position);

        Glide.with(context).load("http://image.tmdb.org/t/p/original"+movieDetails.getPosterPath())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.gradient.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.gradient.setVisibility(View.GONE);
                        return false;
                    }
                }).transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.posterIV);
        holder.title.setText(movieDetails.getTitle());
        holder.description.setText(movieDetails.getDescription());

        holder.posterIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MovieActivity.class);
                i.putExtra("id", movieDetails.getId());
                String transition = context.getString(R.string.transition);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        holder.posterIV,
                        ViewCompat.getTransitionName(holder.posterIV)
                );

                context.startActivity(i, options.toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieDetailsList.size();
    }

    public class MyItem extends RecyclerView.ViewHolder{

        ImageView posterIV, gradient;
        TextView title, description, rating;
        ProgressBar progressBar;

        public MyItem(@NonNull View itemView) {
            super(itemView);
            posterIV = itemView.findViewById(R.id.movie_poster);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
            progressBar = itemView.findViewById(R.id.progress_bar);
            gradient = itemView.findViewById(R.id.gradient);
        }
    }

}
