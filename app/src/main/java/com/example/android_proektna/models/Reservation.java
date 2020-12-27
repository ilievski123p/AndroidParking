package com.example.android_proektna.models;

import android.os.Parcel;

public class Reservation {
    private String CityName;
    private String ParkingName;
    private String Hour;
    private String Date;

    public Reservation(String cityName, String parkingName, String hour, String date) {
        CityName = cityName;
        ParkingName = parkingName;
        Hour = hour;
        Date = date;
    }
    protected Reservation(Parcel in) {
        CityName = in.readString();
        ParkingName = in.readString();
        Hour = in.readString();
        Date = in.readString();
    }
    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getParkingName() {
        return ParkingName;
    }


    public void setParkingName(String parkingName) {
        ParkingName = parkingName;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

        public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CityName);
        dest.writeString(ParkingName);
        dest.writeString(Hour);
        dest.writeString(Date);
    }
}
