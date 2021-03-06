package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by stephanieyoustra on 3/5/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{
    private String[] mWeatherData;
    public ForecastAdapter() {

    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);         //SOLUTION COMBINES THESE TWO LINES INTO ONE
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        String currentItemWeather = mWeatherData[position];                     //COMES FROM SOLUTION CODE
        forecastAdapterViewHolder.mWeatherTextView.setText(currentItemWeather);
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null) {                                         //SOLUTION HAS if (null==weatherData), no {} or else
            return 0;
        } else {
            return mWeatherData.length;
        }
    }

    public void setWeatherData(String[] weatherData) {                                 //COMES FROM SOLUTION CODE
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

}
