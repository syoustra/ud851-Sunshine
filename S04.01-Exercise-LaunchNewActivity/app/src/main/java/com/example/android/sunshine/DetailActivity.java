package com.example.android.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.sunshine.R;

public class DetailActivity extends AppCompatActivity {

                                    //SOLUTION HAD private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
