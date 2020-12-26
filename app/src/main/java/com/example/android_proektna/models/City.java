package com.example.android_proektna.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class City implements Parcelable {
    private String mName;
    private int mImage;
    private ArrayList<Parking> mParkings;

    public City(String name, int image, ArrayList<Parking> parkings) {
        mName = name;
        mImage = image;
        mParkings = parkings;
    }


    protected City(Parcel in) {
        mName = in.readString();
        mImage = in.readInt();
        mParkings = in.createTypedArrayList(Parking.CREATOR);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getName () {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public ArrayList<Parking> getParkings() { return mParkings; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mImage);
        dest.writeTypedList(mParkings);
    }
}

