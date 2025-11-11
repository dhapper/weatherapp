package com.example.weatherapp.model;

import java.util.List;
import java.util.Map;

public class DisplayData {
    private Map<String, Map<String, Double>> dayToTemps;
    private List<String> allTimes;
    private Map<String, Double> dayToAvg;

    public DisplayData(
    		Map<String, Map<String, Double>> dayToTemps,
    		List<String> allTimes,
    		Map<String, Double> dayToAvg
    		) {
        this.dayToTemps = dayToTemps;
        this.allTimes = allTimes;
        this.dayToAvg = dayToAvg;
    }

    public Map<String, Map<String, Double>> getDayToTemps() {
        return dayToTemps;
    }

    public List<String> getAllTimes() {
        return allTimes;
    }
    
    public Map<String, Double> getDayToAvg() {
        return dayToAvg;
    }
}