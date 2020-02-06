package models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class City implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        public City[] newArray(int size) {
            return new City[size];
        }
    };
    @SerializedName("weather")
    private List<Weather> weatherList;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String countryName;

    @SerializedName("coord")
    private Coordinate coordinate;

    @SerializedName("weather")
    private List<Weather> weathersList;

    public City() {
    }

    public City(String name, String countryName) {
        this.name = name;
        this.countryName = countryName;
    }

    public City(Parcel in) {
        this.name = in.readString();
        this.countryName = in.readString();
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
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

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public List<Weather> getWeathersList() {
        return weathersList;
    }

    public void setWeathersList(List<Weather> weathersList) {
        this.weathersList = weathersList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.countryName);
    }
}
