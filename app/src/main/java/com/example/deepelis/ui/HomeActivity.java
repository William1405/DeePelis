package com.example.deepelis.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.deepelis.models.Movie;
import com.example.deepelis.adapter.MovieAdapter;
import com.example.deepelis.adapter.MovieItemClickListener;
import com.example.deepelis.R;
import com.example.deepelis.models.Slide;
import com.example.deepelis.adapter.SliderPagerAdapter;
import com.example.deepelis.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV,moviesRvWeek;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iniViews();


        iniSlider();
        iniPopularMovie();
        iniWeekMovies();


    }

    private void iniWeekMovies() {
          MovieAdapter weekMovieAdapter = new  MovieAdapter( this, DataSource.getWeekMovies(), this);
          moviesRvWeek.setAdapter(weekMovieAdapter);
          moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

    }

    private void iniPopularMovie() {
        //Recyclerview de peliculas



        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovie(), this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "SPACE JUM 2"));
        lstSlides.add(new Slide(R.drawable.slide2, "RAYA  AND THE LAST DRAGON"));
        lstSlides.add(new Slide(R.drawable.slide3, "TOM Y JERRY"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter((adapter));
        //setup time
        Timer timer =new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 5000);
        indicator.setupWithViewPager(sliderpager,true);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_page);
        indicator=findViewById(R.id.indicator);
        MoviesRV =findViewById(R.id.Rv_movies);
        moviesRvWeek=findViewById(R.id.rv_movies_week);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this,MovieDetailActivity.class);

        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());



        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                                                                                movieImageView,"sharedName");

        startActivity(intent,options.toBundle());

       //Toast.makeText(this,"Pelicula : "+movie.getTitle(),Toast.LENGTH_LONG).show();


    }





    class SliderTimer extends TimerTask {
        @Override

        public void run(){
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}
