package com.smartrideadvisor.utils;

import com.smartrideadvisor.model.Station;
import java.util.List;

public class RideSafetyView {

    public void displayWeatherData(double rainfall, double windSpeed) {
        System.out.println("Weather Data:");
        System.out.printf("Rainfall: %.2f mm%n", rainfall);
        System.out.printf("Wind Speed: %.2f km/h%n", windSpeed);
    }

    public void displaySafetyAdvice(String safety) {
        System.out.println("Ride Safety Advice: " + safety);
    }

    public void displayError(String message) {
        System.err.println("Error: " + message);
    }

    public void displayStations(String title, List<Station> stations) {
        System.out.println("\n" + title + ":");
        if (stations.isEmpty()) {
            System.out.println("No stations available.");
            return;
        }
        for (Station station : stations) {
            System.out.printf("ID: %s - Name: %s%n", station.getId(), station.getName());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
