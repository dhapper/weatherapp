package com.example.weatherapp.util;

import java.io.IOException;
import java.net.ServerSocket;

public class PortUtil {
	
	public static boolean isPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Successfully bound to the port, so it's free
            return true;
        } catch (IOException e) {
            // Failed to bind, port is likely in use
            return false;
        }
    }

}
