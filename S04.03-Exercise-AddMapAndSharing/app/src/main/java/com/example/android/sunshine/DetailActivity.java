package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String mForecast;
    private TextView mWeatherDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherDisplay = (TextView) findViewById(R.id.tv_display_weather);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mForecast = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mWeatherDisplay.setText(mForecast);
            }
        }
    }

    // COMPLETED (3) Create a menu with an item with id of action_share
    // COMPLETED (4) Display the menu and implement the forecast sharing functionality


                                                                               //NEXT METHOD FROM SOLUTION
//                    private Intent createShareForecastIntent() {
//                        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
//                                .setType("text/plain")
//                                .setText(mForecast + FORECAST_SHARE_HASHTAG)
//                                .getIntent();
//                        return shareIntent;
//                    }

                                                                            //The Solution code here runs the same, but looks a little different

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
                                                                            //NEXT TWO LINES FROM SOLUTION
//                MenuItem menuItem = menu.findItem(R.id.action_share);
//                menuItem.setIntent(createShareForecastIntent());

        return true;
    }

                                                                            //SOLUTION CODE DOES NOT HAVE THESE LAST TWO METHODs
                                                                            //THIS APPROACH, THOUGH, LOOKS ESSENTIALLY THE SAME
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            String infoToBeShared = mForecast;
            shareText(mForecast);
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareText(String textToBeShared) {
        String mimeType = "text/plain";
        String chooserTitle = "How would you like to share this?";
        ShareCompat.IntentBuilder.from(this)
                .setChooserTitle(chooserTitle)
                .setType(mimeType)
                .setText(textToBeShared)
                .startChooser();
    }
}