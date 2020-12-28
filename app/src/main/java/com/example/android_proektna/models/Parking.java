package com.example.android_proektna.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Parking implements Parcelable {

    private String parkingName;
    private int parkingPlaces;
    private int freePlaces;
    private String city;
    private String lat;
    private String lng;

    public Parking(String parkingName, int parkingPlaces, int freePlaces, String cityName, String lat, String lng) {
        this.parkingName = parkingName;
        this.parkingPlaces = parkingPlaces;
        this.freePlaces = freePlaces;
        this.city = cityName;
        this.lat = lat;
        this.lng = lng;
    }

    protected Parking(Parcel in) {
        parkingName = in.readString();
        parkingPlaces = in.readInt();
        freePlaces = in.readInt();
        city = in.readString();
        lat = in.readString();
        lng = in.readString();
    }

    public static final Creator<Parking> CREATOR = new Creator<Parking>() {
        @Override
        public Parking createFromParcel(Parcel in) {
            return new Parking(in);
        }

        @Override
        public Parking[] newArray(int size) {
            return new Parking[size];
        }
    };

    public String getParkingName() {
        return parkingName;
    }

    public int getParkingPlaces() {
        return parkingPlaces;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public String getCityName() {
        return city;
    }

    public void reserveParking() {
        freePlaces--;
    }

    public int getTakenPlaces() {
        return parkingPlaces - freePlaces;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(parkingName);
        dest.writeInt(parkingPlaces);
        dest.writeInt(freePlaces);
        dest.writeString(city);
        dest.writeString(lat);
        dest.writeString(lng);
    }
}
