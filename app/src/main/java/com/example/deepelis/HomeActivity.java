package com.example.deepelis;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

          sliderpager = findViewById(R.id.slider_page);
          indicator=findViewById(R.id.indicator);







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