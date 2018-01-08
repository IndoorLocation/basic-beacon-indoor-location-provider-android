package io.indoorlocation.basicbeaconlocationprovider;

public class LatLngFloor {

    private double latitude;
    private double longitude;
    private Double floor;

    public LatLngFloor(double latitude, double longitude, Double floor) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.floor = floor;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor;
    }

}
