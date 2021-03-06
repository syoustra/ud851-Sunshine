package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mDisplayWeather;
    private String mWeatherToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        mDisplayWeather = (TextView) findViewById(R.id.tv_display_weather);     //I HADN'T INCLUDED THIS TEXTVIEW

        Intent originatingIntent = getIntent();
        if (originatingIntent != null) {                                        //SOLUTION ADDED IN THIS LINE
            if (originatingIntent.hasExtra(Intent.EXTRA_TEXT)) {
                mWeatherToDisplay = originatingIntent.getStringExtra(Intent.EXTRA_TEXT);
                mDisplayWeather.setText(mWeatherToDisplay);

            }
        }
    }
}