package com.example.deepelis.utils;

import com.example.deepelis.R;
import com.example.deepelis.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovie(){
        List<Movie> lstMovies= new ArrayList<>();
        lstMovies.add(new Movie("Kong vs Godzilla", R.drawable.king,R.drawable.godzilla_vs_kong_fondo) );
        lstMovies.add(new Movie("Los Croods2", R.drawable.croods,R.drawable.los_croods_fondo));
        lstMovies.add(new Movie("Liga de la justicia", R.drawable.liga,R.drawable.liga_fondo));
        lstMovies.add(new Movie("Kong vs Godzilla", R.drawable.king,R.drawable.godzilla_vs_kong_fondo) );
        lstMovies.add(new Movie("Los Croods2", R.drawable.croods,R.drawable.los_croods_fondo));
        lstMovies.add(new Movie("Liga de la justicia", R.drawable.liga,R.drawable.liga_fondo));
        return lstMovies;

    }

    public static List<Movie> getWeekMovies(){
        List<Movie> lstMovies= new ArrayList<>();
        lstMovies.add(new Movie("EL irlandés", R.drawable.irlandes,R.drawable.el_irlandes_fondo) );
        lstMovies.add(new Movie("300", R.drawable.p300,R.drawable.p300_fondo) );
        lstMovies.add(new Movie("Soul", R.drawable.soul,R.drawable.soul_fondo));
        lstMovies.add(new Movie("EL irlandés", R.drawable.irlandes,R.drawable.el_irlandes_fondo) );
        lstMovies.add(new Movie("300", R.drawable.p300,R.drawable.p300_fondo) );
        lstMovies.add(new Movie("Soul", R.drawable.soul,R.drawable.soul_fondo));

        return lstMovies;
    }
}
