package com.example.deepelis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_page);


        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "SPACE JUM 2"));
        lstSlides.add(new Slide(R.drawable.slide2, "RAYA  AND THE LAST DRAGON"));
        lstSlides.add(new Slide(R.drawable.slide3, "TOM Y JERRY"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter((adapter));
    }
}
