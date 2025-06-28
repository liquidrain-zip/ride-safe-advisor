package com.smartrideadvisor.model;

import java.util.List;

public class WindReading {
    private String timestamp;
    private List<WindValue> data;

    // Getters and setters
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public List<WindValue> getData() { return data; }
    public void setData(List<WindValue> data) { this.data = data; }
}
