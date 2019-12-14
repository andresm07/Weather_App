package com.example.proyectofinal;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        public City[] newArray(int size) {
            return new City[size];
        }
    };
    private String name;
    private String countryName;
    private String weather;

    public City(String name, String countryName) {
        this.name = name;
        this.countryName = countryName;
    }

    public City(String name, String countryName, String weather) {
        this.name = name;
        this.countryName = countryName;
        this.weather = weather;
    }

    public City(Parcel in) {
        this.name = in.readString();
        this.countryName = in.readString();
        this.weather = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.countryName);
        dest.writeString(this.weather);
    }
}
