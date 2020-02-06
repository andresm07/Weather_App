package models;

import com.google.gson.annotations.SerializedName;

public class Coordinate {

    @SerializedName("lat")
    private Double latitude;

    @SerializedName("lon")
    private Double longitude;

    public Coordinate() {

    }

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
