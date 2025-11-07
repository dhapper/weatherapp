package com.example.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.weatherapp.util.PortUtil;

@SpringBootApplication
public class WeatherappApplication {

	public static void main(String[] args) {
		
		int port = 8080;
        if (PortUtil.isPortAvailable(port)) {
        	SpringApplication.run(WeatherappApplication.class, args);
        	System.out.println("App started successfully!");
        } else {
            System.out.println("Port " + port + " is in use. Cannot start app on this port.\nReccomend restarting eclipse and running again.");
        }
	}

}
