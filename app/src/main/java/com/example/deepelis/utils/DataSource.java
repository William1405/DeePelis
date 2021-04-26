package com.example.deepelis.utils;

import com.example.deepelis.R;
import com.example.deepelis.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovie(){
        List<Movie> lstMovies= new ArrayList<>();
        lstMovies.add(new Movie("Kong vs Godzilla", R.drawable.king,R.drawable.king) );
        lstMovies.add(new Movie("Los Croods2", R.drawable.croods,R.drawable.croods) );
        lstMovies.add(new Movie("Liga de la justicia", R.drawable.liga,R.drawable.liga));
        lstMovies.add(new Movie("Kong vs Godzilla", R.drawable.king,R.drawable.king) );
        lstMovies.add(new Movie("Los Croods2", R.drawable.croods,R.drawable.croods) );
        lstMovies.add(new Movie("Liga de la justicia", R.drawable.liga,R.drawable.liga));
        return lstMovies;

    }

    public static List<Movie> getWeekMovies(){
        List<Movie> lstMovies= new ArrayList<>();
        lstMovies.add(new Movie("EL IRLANDÉS", R.drawable.irlandes,R.drawable.irlandes) );
        lstMovies.add(new Movie("300", R.drawable.p300,R.drawable.p300) );
        lstMovies.add(new Movie("SOUL", R.drawable.soul,R.drawable.soul));
        lstMovies.add(new Movie("EL IRLANDÉS", R.drawable.irlandes,R.drawable.irlandes) );
        lstMovies.add(new Movie("300", R.drawable.p300,R.drawable.p300) );
        lstMovies.add(new Movie("SOUL", R.drawable.soul,R.drawable.soul));

        return lstMovies;
    }
}
