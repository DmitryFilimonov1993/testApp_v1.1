package com.example.testapp_v11.controller;

import android.support.v4.app.Fragment;

import com.example.testapp_v11.helper.SingleFragmentActivity;

public class WeatherActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new WeatherFragment();
    }
}
