package com.smartrideadvisor.model;

import java.util.List;

public class ReadingData {
    private String timestamp;
    private List<Reading> data;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Reading> getData() {
        return data;
    }

    public void setData(List<Reading> data) {
        this.data = data;
    }
}
