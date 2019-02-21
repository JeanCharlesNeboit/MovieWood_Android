package com.example.moviewood.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewood.R;
import com.example.moviewood.activity.DetailActivity;
import com.example.moviewood.model.Movie;
import com.example.moviewood.model.MovieShowTimes;
import com.example.moviewood.model.Screening;
import com.example.moviewood.model.Screenings;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScreeningAdapter extends BaseAdapter {
    private ArrayList<Screening> screenings;

    public ScreeningAdapter(ArrayList<Screening> screenings) {
        this.screenings = screenings;
    }

    @Override
    public int getCount() {
        return screenings.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.screening, parent, false);
        TextView textView = view.findViewById(R.id.text_view_screening);
        textView.setText(screenings.get(position).name);
        return view;
    }

    static class ScreeningViewHolder extends RecyclerView.ViewHolder {
        TextView screeningTextView;

        ScreeningViewHolder(View view) {
            super(view);
            screeningTextView = view.findViewById(R.id.text_view_screening);
        }
    }
}
