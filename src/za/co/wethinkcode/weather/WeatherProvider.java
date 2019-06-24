package za.co.wethinkcode.weather;

import za.co.wethinkcode.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String weather[] = {"RAIN", "FOG", "SNOW", "HAIL"};

    WeatherProvider(){
        //do some stuff
    }

    WeatherProvider getProvider(){
        //do some stuff
        return WeatherProvider.weatherProvider;
    }

    String getCurrentWeather(Coordinates coordinates){
        //do some stuff
        int height = coordinates.getHeight();
        int longi = coordinates.getLongitude();
        int lat = coordinates.getLatitude();

        
    }
}
