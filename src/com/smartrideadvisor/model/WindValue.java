package com.smartrideadvisor.model;

public class WindValue {
    private String stationId;
    private double value;  // wind speed in knots

    // Getters and setters
    public String getStationId() { return stationId; }
    public void setStationId(String stationId) { this.stationId = stationId; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}
