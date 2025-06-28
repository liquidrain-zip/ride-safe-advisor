package com.smartrideadvisor.model;

import java.util.List;

public class WindSpeedData {
    private List<Station> stations;
    private List<WindReading> readings;
    private String readingType;
    private String readingUnit;

    // Getters and setters

    public List<Station> getStations() { return stations; }
    public void setStations(List<Station> stations) { this.stations = stations; }

    public List<WindReading> getReadings() { return readings; }
    public void setReadings(List<WindReading> readings) { this.readings = readings; }

    public String getReadingType() { return readingType; }
    public void setReadingType(String readingType) { this.readingType = readingType; }

    public String getReadingUnit() { return readingUnit; }
    public void setReadingUnit(String readingUnit) { this.readingUnit = readingUnit; }
}
