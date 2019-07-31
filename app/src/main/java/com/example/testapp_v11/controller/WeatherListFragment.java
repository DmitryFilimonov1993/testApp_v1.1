package com.example.testapp_v11.controller;

import android.content.Intent;
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
import android.widget.Toast;


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

//        mRecyclerView = mView.findViewById(R.id.weather_recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        updateUI();
         return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.weather_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

    }

    private void updateUI(){

        WeatherLab weatherLab = WeatherLab.getInstance(getActivity());
        List<WeatherDate> weatherDates = weatherLab.getWeatherDates();

        if (mAdapter == null) {
            mAdapter = new WeatherAdapter(weatherDates);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

    }

    private class WeatherHolder extends RecyclerView.ViewHolder {
        private TextView mCityView, mDateView;
        private WeatherDate mWeatherDate;

        public WeatherHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.list_item_weather, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = WeatherActivity.newIntent(getActivity(), mWeatherDate.getId());
                    startActivity(intent);

                }
            });
            mCityView = itemView.findViewById(R.id.weather_city);
            mDateView = itemView.findViewById(R.id.weather_date_view);

        }

        public void bind(WeatherDate weatherDate){

            mWeatherDate = weatherDate;
            mCityView.setText(mWeatherDate.getCity());
            mDateView.setText(mWeatherDate.getDate().toString());

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

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
