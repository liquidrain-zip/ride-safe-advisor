package com.smartrideadvisor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reading {
    @JsonProperty("stationId")
    private String stationId;

    @JsonProperty("value")
    private double value;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
