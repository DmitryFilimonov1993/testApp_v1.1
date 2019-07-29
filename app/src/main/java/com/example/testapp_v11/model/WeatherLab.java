package com.example.testapp_v11.model;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WeatherLab {

    private static WeatherLab sWeatherLab;
    private List<WeatherDate> mWeatherDates;

    public static WeatherLab getInstance(Context context){

        if (sWeatherLab == null){
            sWeatherLab = new WeatherLab(context);
        }
        return sWeatherLab;
    }

    private WeatherLab(Context context){

        mWeatherDates = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            WeatherDate weatherDate = new WeatherDate();
            weatherDate.setCity("City#" + i);
            weatherDate.setSolved(i%2 == 0);
            mWeatherDates.add(weatherDate);
        }
    }

    public List<WeatherDate> getWeatherDates() {
        return mWeatherDates;
    }

    public WeatherDate getWeatherDate(UUID id){

        for (WeatherDate weatherDate: mWeatherDates) {
            if (weatherDate.getId().equals(id)){
                return weatherDate;
            }
        }
        return null;
    }
}
