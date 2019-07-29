package com.example.testapp_v11.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.testapp_v11.R;
import com.example.testapp_v11.model.WeatherDate;

public class WeatherFragment extends Fragment {


    private WeatherDate mWeatherDate;
    private EditText mEditText;
    private CheckBox mCheckBox;
    private Button mButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherDate = new WeatherDate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_weather, container, false);

        mEditText = mView.findViewById(R.id.weather_title);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mWeatherDate.setCity(mEditText.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mButton = mView.findViewById(R.id.weather_date);
        mButton.setText(mWeatherDate.getDate().toString());
        mButton.setEnabled(false);

        mCheckBox = mView.findViewById(R.id.weather_solved);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mWeatherDate.setSolved(isChecked);
            }
        });

        return mView;


    }
}
