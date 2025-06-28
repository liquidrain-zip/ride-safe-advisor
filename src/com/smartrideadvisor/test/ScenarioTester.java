package com.smartrideadvisor.test;

import com.smartrideadvisor.fuzzy.FuzzyLogicEngine;

public class ScenarioTester {
    public static void main(String[] args) {
        FuzzyLogicEngine engine = new FuzzyLogicEngine("fcl/advisor.fcl");

        // Light rainfall scenarios
        test(engine, 0.0, 0.0);   // No rain, no wind
        test(engine, 1.0, 2.0);   // Light rain, calm wind
        test(engine, 1.0, 5.0);   // Light rain, breezy wind
        test(engine, 1.0, 10.0);  // Light rain, strong wind

        // Moderate rainfall scenarios
        test(engine, 4.0, 0.0);   // Moderate rain, calm wind
        test(engine, 4.0, 5.0);   // Moderate rain, breezy wind
        test(engine, 4.0, 10.0);  // Moderate rain, strong wind

        // Heavy rainfall scenarios
        test(engine, 10.0, 0.0);  // Heavy rain, calm wind
        test(engine, 10.0, 5.0);  // Heavy rain, breezy wind
        test(engine, 10.0, 10.0); // Heavy rain, strong wind

        // Borderline cases
        test(engine, 3.0, 3.0);   // Boundary moderate rain and calm/breezy wind
        test(engine, 5.0, 6.0);   // Boundary moderate rain and breezy/strong wind
        test(engine, 8.0, 7.0);   // Heavy rain and breezy wind boundary

        // Extreme values
        test(engine, 15.0, 0.0);  // Very heavy rain, no wind
        test(engine, 0.0, 15.0);  // No rain, very strong wind
        test(engine, 20.0, 20.0); // Extreme rain and wind

    }

    private static void test(FuzzyLogicEngine engine, double rain, double wind) {
        String result = engine.evaluateSafety(rain, wind);
        System.out.printf("Input -> Rainfall: %.1f mm, Wind Speed: %.1f km/h => Safety Advice: %s%n",
                rain, wind, result);
    }
}
