package com.example.deepelis.adapter;

import android.widget.ImageView;

import com.example.deepelis.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
}
