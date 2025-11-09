package com.example.weatherapp.model;

import java.util.List;
import java.util.Map;

public class WeatherData {
    private double latitude;
    private double longitude;
    private Map<String, String> hourly_units;
    private Hourly hourly;

    // inner class for hourly data
    public static class Hourly {
        private List<String> time;
        private List<Double> temperature_2m;

        // getters and setters
        public List<String> getTime() { return time; }
        public void setTime(List<String> time) { this.time = time; }

        public List<Double> getTemperature_2m() { return temperature_2m; }
        public void setTemperature_2m(List<Double> temperature_2m) { this.temperature_2m = temperature_2m; }
    }

    // getters and setters
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public Map<String, String> getHourly_units() { return hourly_units; }
    public void setHourly_units(Map<String, String> hourly_units) { this.hourly_units = hourly_units; }

    public Hourly getHourly() { return hourly; }
    public void setHourly(Hourly hourly) { this.hourly = hourly; }
}
