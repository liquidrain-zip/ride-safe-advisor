package com.smartrideadvisor.controller;

import com.smartrideadvisor.fuzzy.FuzzyLogicEngine;
import com.smartrideadvisor.model.Station;
import com.smartrideadvisor.service.RainfallService;
import com.smartrideadvisor.utils.RideSafetyView;

import java.util.List;
import java.util.Scanner;

public class RideSafetyController {
    private final RainfallService service;
    private final FuzzyLogicEngine engine;
    private final RideSafetyView view;

    public RideSafetyController() {
        this.service = new RainfallService();
        this.engine = new FuzzyLogicEngine("fcl/advisor.fcl");
        this.view = new RideSafetyView();
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Fetch latest data once before loop
            service.fetchRainfallData();
            service.fetchWindSpeedData();

            // Get list of stations
            List<Station> rainfallStations = service.getRainfallStations();
            List<Station> windSpeedStations = service.getWindSpeedStations();
            
            view.displayMessage("Smart Ride Advisor");
            view.displayMessage("------------------");

            // Display stations for user selection
            view.displayStations("Rainfall Stations", rainfallStations);
            view.displayStations("Wind Speed Stations", windSpeedStations);

            while (true) {
                view.displayMessage("Enter a station ID to view localized data, or press 'Enter' to view overall data, or type 'exit' to exit the program:");
                String selectedStationId = scanner.nextLine().trim().toUpperCase();

                if ("EXIT".equals(selectedStationId)) {
                    view.displayMessage("See you on the road, Ride Safe!.");
                    break;
                }

                double rainfall;
                double windSpeed;

                if (selectedStationId.isEmpty()) {
                    rainfall = service.getLatestRainfall();
                    windSpeed = service.getAverageWindSpeedKmh();
                    view.displayMessage("Displaying overall rainfall and wind speed data for Singapore.");
                } else {
                	// Find station name
                    String stationName = "Unknown Station";
                    for (Station station : rainfallStations) {
                        if (station.getId().equalsIgnoreCase(selectedStationId)) {
                            stationName = station.getName();
                            break;
                        }
                    }
                    if ("Unknown Station".equals(stationName)) {
                        for (Station station : windSpeedStations) {
                            if (station.getId().equalsIgnoreCase(selectedStationId)) {
                                stationName = station.getName();
                                break;
                            }
                        }
                    }
                    view.displayMessage("Displaying data for station: " + stationName + " (ID: " + selectedStationId + ")");
                	
                    rainfall = service.getRainfallByStationId(selectedStationId);
                    windSpeed = service.getWindSpeedByStationId(selectedStationId);
                }

                String safety = engine.evaluateSafety(rainfall, windSpeed);

                view.displayWeatherData(rainfall, windSpeed);
                view.displaySafetyAdvice(safety);
            }
        } catch (Exception e) {
            view.displayError("Error fetching or processing data: " + e.getMessage());
        }
    }
}
