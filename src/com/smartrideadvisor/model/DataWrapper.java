package com.smartrideadvisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataWrapper {
    private List<Station> stations;
    private List<ReadingData> readings;

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<ReadingData> getReadings() {
        return readings;
    }

    public void setReadings(List<ReadingData> readings) {
        this.readings = readings;
    }
}
