package com.example.moviewood.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewood.R;
import com.example.moviewood.activity.DetailActivity;
import com.example.moviewood.activity.MainActivity;
import com.example.moviewood.component.ScreeningGridView;
import com.example.moviewood.model.Movie;
import com.example.moviewood.model.MovieShowTimes;
import com.example.moviewood.model.Screening;
import com.example.moviewood.model.Screenings;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieShowTimes> movieShowTimes;
    private Context context;

    public MovieAdapter(List<MovieShowTimes> movies, Context context) {
        this.movieShowTimes = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movie movie = movieShowTimes.get(position).onShow.movie;
        final ArrayList<Screenings> screenings = movieShowTimes.get(position).scr;
        Picasso.get().load(movie.poster.href).into(holder.imageView);
        holder.titleTextView.setText(movie.title);
        holder.detailTextView.setText(movie.getDuration() + " | " + movie.genre.get(0).name);
        holder.pressRatingBar.setRating(movie.statistics.pressRating);
        holder.spectRatingBar.setRating(movie.statistics.userRating);
        if (screenings != null) {
            ArrayList<Screening> s = new ArrayList<Screening>();
            for (Screening screening : screenings.get(0).t) {
                s.add(screening);
            }
            holder.screeningsGridView.setAdapter(new ScreeningAdapter(s));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("movie", movie);
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movieShowTimes.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView detailTextView;
        TextView spectRatingTextView;
        TextView pressRatingTextView;
        RatingBar spectRatingBar;
        RatingBar pressRatingBar;
        ScreeningGridView screeningsGridView;

        MovieViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_view);
            titleTextView = view.findViewById(R.id.text_view1);
            detailTextView = view.findViewById(R.id.text_view2);
            spectRatingTextView = view.findViewById(R.id.text_view4);
            spectRatingBar = view.findViewById(R.id.rating2);
            pressRatingTextView = view.findViewById(R.id.text_view3);
            pressRatingBar = view.findViewById(R.id.rating1);
            screeningsGridView = view.findViewById(R.id.gridview);
        }
    }
}
