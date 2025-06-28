package com.smartrideadvisor.fuzzy;

import net.sourceforge.jFuzzyLogic.FIS;

public class FuzzyLogicEngine {
    private final FIS fis;

    public FuzzyLogicEngine(String fclPath) {
        fis = FIS.load(fclPath, true);
        if (fis == null) throw new RuntimeException("FCL file could not be loaded.");
    }

    public String evaluateSafety(double rainfall, double windSpeed) {
        fis.setVariable("rainfall", rainfall);
        fis.setVariable("windSpeed", windSpeed);

        fis.evaluate();

        double risk = fis.getVariable("risk").getValue();

        if (risk < 3) return "Safe to Ride";
        else if (risk < 6) return "Ride with Caution";
        else return "Unsafe to Ride";
    }
}
