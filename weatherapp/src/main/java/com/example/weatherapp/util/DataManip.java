package com.example.weatherapp.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.example.weatherapp.model.DisplayData;
import com.example.weatherapp.model.WeatherData;

public class DataManip {

    public static DisplayData transformToDisplayData(WeatherData data) {
        Map<String, Map<String, Double>> dayToTemps = new LinkedHashMap<>();

        List<String> times = data.getHourly().getTime();
        List<Double> temps = data.getHourly().getTemperature_2m();

        DateTimeFormatter inputFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        DateTimeFormatter dayFmt = DateTimeFormatter.ofPattern("MMM dd");
        DateTimeFormatter hourFmt = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < times.size(); i++) {
            LocalDateTime dateTime = LocalDateTime.parse(times.get(i), inputFmt);
            String date = dateTime.format(dayFmt);
            String hour = dateTime.format(hourFmt);
            Double temp = temps.get(i);

            dayToTemps.computeIfAbsent(date, k -> new LinkedHashMap<>());
            dayToTemps.get(date).put(hour, temp);
        }

        List<String> allTimes = new ArrayList<>();
        if (!dayToTemps.isEmpty()) {
            allTimes.addAll(dayToTemps.values().iterator().next().keySet());
        }
        
        // Calculate average for each day
        Map<String, Double> dayToAvg = new LinkedHashMap<>();
        for (var entry : dayToTemps.entrySet()) {
            String day = entry.getKey();
            Collection<Double> dayTemps = entry.getValue().values();

            double sum = 0;
            for (Double t : dayTemps) sum += t;
            double avg = sum / dayTemps.size();

            dayToAvg.put(day, avg);
        }

        return new DisplayData(dayToTemps, allTimes, dayToAvg);
    }
}
