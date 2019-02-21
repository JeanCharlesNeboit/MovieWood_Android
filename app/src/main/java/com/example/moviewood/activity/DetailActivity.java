package com.example.moviewood.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.moviewood.model.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.moviewood.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movie = (Movie)this.getIntent().getSerializableExtra("movie");

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle(movie.title);

        ImageView poster = (ImageView) findViewById(R.id.movie_poster);
        String id = movie.trailer.href.split("v=")[1];
        Picasso.get().load("https://img.youtube.com/vi/" + id + "/maxresdefault.jpg").into(poster);
        ImageButton play = (ImageButton) findViewById(R.id.youtube_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.trailer.href));
                DetailActivity.this.startActivity(intent);
            }
        });

        TextView textView = (TextView) findViewById(R.id.movie);
        textView.setText(movie.getDuration() + " | " + movie.genre.get(0).name);

        RatingBar press = (RatingBar) findViewById(R.id.rb_press);
        press.setRating(movie.statistics.pressRating);
        RatingBar spect = (RatingBar) findViewById(R.id.rb_spect);
        spect.setRating(movie.statistics.userRating);
    }

}
