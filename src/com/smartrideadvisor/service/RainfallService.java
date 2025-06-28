package com.smartrideadvisor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartrideadvisor.model.*;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.OptionalDouble;

public class RainfallService {
    private static final String RAINFALL_API = "https://api-open.data.gov.sg/v2/real-time/api/rainfall";
    private static final String WINDSPEED_API = "https://api-open.data.gov.sg/v2/real-time/api/wind-speed";

    private ApiResponse rainfallResponse;
    private WindSpeedApiResponse windSpeedResponse;

    public void fetchRainfallData() throws Exception {
        URL url = new URL(RAINFALL_API);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (InputStream in = conn.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            rainfallResponse = mapper.readValue(in, ApiResponse.class);
        }
    }

    public void fetchWindSpeedData() throws Exception {
        URL url = new URL(WINDSPEED_API);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (InputStream in = conn.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            windSpeedResponse = mapper.readValue(in, WindSpeedApiResponse.class);
        }
    }

    // Get list of rainfall stations
    public List<Station> getRainfallStations() {
        if (rainfallResponse == null || rainfallResponse.getData() == null) return List.of();
        return rainfallResponse.getData().getStations();
    }

    // Get list of wind speed stations
    public List<Station> getWindSpeedStations() {
        if (windSpeedResponse == null || windSpeedResponse.getData() == null) return List.of();
        return windSpeedResponse.getData().getStations();
    }

    // Get rainfall for a specific station by id
    public double getRainfallByStationId(String stationId) {
        if (rainfallResponse == null || rainfallResponse.getData() == null || rainfallResponse.getData().getReadings().isEmpty())
            return 0.0;

        List<ReadingData> readings = rainfallResponse.getData().getReadings();
        // Assuming latest reading is readings.get(0)
        return readings.get(0).getData().stream()
                .filter(r -> r.getStationId().equals(stationId))
                .mapToDouble(Reading::getValue)
                .findFirst()
                .orElse(0.0);
    }

    // Get wind speed (km/h) for a specific station by id
    public double getWindSpeedByStationId(String stationId) {
        if (windSpeedResponse == null || windSpeedResponse.getData() == null || windSpeedResponse.getData().getReadings().isEmpty())
            return 0.0;

        List<WindValue> windValues = windSpeedResponse.getData().getReadings().get(0).getData();

        OptionalDouble knotsOpt = windValues.stream()
                .filter(w -> w.getStationId().equals(stationId))
                .mapToDouble(WindValue::getValue)
                .findFirst();

        return knotsOpt.isPresent() ? knotsOpt.getAsDouble() * 1.852 : 0.0; // Convert knots to km/h
    }

    // Get max rainfall overall
    public double getLatestRainfall() {
        if (rainfallResponse == null || rainfallResponse.getData() == null || rainfallResponse.getData().getReadings().isEmpty()) return 0.0;

        List<ReadingData> readingDataList = rainfallResponse.getData().getReadings();

        return readingDataList.get(0).getData().stream()
                .mapToDouble(Reading::getValue)
                .max()
                .orElse(0.0);
    }

    // Get average wind speed overall (km/h)
    public double getAverageWindSpeedKmh() {
        if (windSpeedResponse == null || windSpeedResponse.getData() == null || windSpeedResponse.getData().getReadings().isEmpty()) return 0.0;

        List<WindValue> windValues = windSpeedResponse.getData().getReadings().get(0).getData();

        double avgKnots = windValues.stream()
                .mapToDouble(WindValue::getValue)
                .average()
                .orElse(0.0);

        return avgKnots * 1.852; // Convert knots to km/h
    }
}
