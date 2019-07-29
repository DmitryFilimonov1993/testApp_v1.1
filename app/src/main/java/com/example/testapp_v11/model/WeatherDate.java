package com.example.testapp_v11.model;

import java.util.Date;
import java.util.UUID;

public class WeatherDate {

    private UUID mId;
    private String mCity;
    private Date mDate;
    private boolean mSolved;

    public WeatherDate() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
