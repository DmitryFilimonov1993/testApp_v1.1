package com.example.testapp_v11.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.testapp_v11.helper.SingleFragmentActivity;

import java.util.UUID;

public class WeatherActivity extends SingleFragmentActivity {

    public static final String EXTRA_WEATHER_ID = "com.example.testapp_v11.model.weather_id";

    public static Intent newIntent(Context packageContext, UUID weatherID){

        Intent intent = new Intent(packageContext, WeatherActivity.class);
        intent.putExtra(EXTRA_WEATHER_ID, weatherID);
        return intent;

    }


    @Override
    protected Fragment createFragment() {
        UUID weatherID = (UUID)getIntent()
                .getSerializableExtra(EXTRA_WEATHER_ID);
        return WeatherFragment.newInstance(weatherID);
    }



}
