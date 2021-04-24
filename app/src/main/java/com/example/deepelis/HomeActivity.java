package com.example.deepelis;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sliderpager = findViewById(R.id.slider_page);
        indicator=findViewById(R.id.indicator);
        MoviesRV =findViewById(R.id.Rv_movies);
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "SPACE JUM 2"));
        lstSlides.add(new Slide(R.drawable.slide2, "RAYA  AND THE LAST DRAGON"));
        lstSlides.add(new Slide(R.drawable.slide3, "TOM Y JERRY"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter((adapter));
        //setup time
        Timer timer =new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager,true);
        //Recyclerview de peliculas

        List<Movie> lstMovies= new ArrayList<>();
        lstMovies.add(new Movie("Kong vs Godzilla", R.drawable.king) );
        lstMovies.add(new Movie("Los Croods2", R.drawable.croods) );
        lstMovies.add(new Movie("Liga de la justicia", R.drawable.liga));
        lstMovies.add(new Movie("Kong vs Godzilla", R.drawable.king) );
        lstMovies.add(new Movie("Los Croods2", R.drawable.croods) );
        lstMovies.add(new Movie("Liga de la justicia", R.drawable.liga));

        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies, this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));









    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this,MovieDetailActivity.class);

        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());


        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                                                                                movieImageView,"sharedName");

        startActivity(intent,options.toBundle());

        Toast.makeText(this,"Pelicula : "+movie.getTitle(),Toast.LENGTH_LONG).show();


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
