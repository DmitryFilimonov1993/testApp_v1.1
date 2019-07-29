package com.example.testapp_v11.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.testapp_v11.R;
import com.example.testapp_v11.model.WeatherDate;
import com.example.testapp_v11.model.WeatherLab;

import java.util.List;

public class WeatherListFragment extends Fragment {

   private RecyclerView mRecyclerView;
   private WeatherAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_list_weather, container, false);

        mRecyclerView = mView.findViewById(R.id.weather_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return mView;
    }

    private void updateUI(){

        WeatherLab weatherLab = WeatherLab.getInstance(getActivity());
        List<WeatherDate> weatherDates = weatherLab.getWeatherDates();
        mAdapter = new WeatherAdapter(weatherDates);
        mRecyclerView.setAdapter(mAdapter);

    }

    private class WeatherHolder extends RecyclerView.ViewHolder {
        private TextView mCityView, mDateView;
        private WeatherDate mWeatherDate;

        public WeatherHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.list_item_weather, parent, false));

            mCityView = itemView.findViewById(R.id.weather_city);
            mDateView = itemView.findViewById(R.id.weather_date);

        }

        public void bind(WeatherDate weatherDate){

            try{

            mWeatherDate = weatherDate;
            mCityView.setText(mWeatherDate.getCity());
            mDateView.setText(mWeatherDate.getDate().toString());
        }
            catch (Exception e){
            mDateView.setText("Бричка");
            }
        }
    }

    private class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder>{

        private List<WeatherDate> mWeatherDates;

        public WeatherAdapter(List<WeatherDate> weatherDates) {
            mWeatherDates = weatherDates;
        }

        @NonNull
        @Override
        public WeatherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new WeatherHolder(layoutInflater, viewGroup);

        }

        @Override
        public void onBindViewHolder(@NonNull WeatherHolder weatherHolder, int i) {
            WeatherDate weatherDate = mWeatherDates.get(i);
            weatherHolder.bind(weatherDate);
        }

        @Override
        public int getItemCount() {
            return mWeatherDates.size();
        }

    }
}
