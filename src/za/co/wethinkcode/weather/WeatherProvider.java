package za.co.wethinkcode.weather;
import java.lang.Math;
import za.co.wethinkcode.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String weather[] = {"RAIN", "FOG", "SNOW", "SUN"};

    WeatherProvider(){
        //do some stuff
    }

    static WeatherProvider getProvider(){
        //do some stuff
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    String getCurrentWeather(Coordinates coordinates){
        //do some stuff
        int height = coordinates.getHeight();
        int longi = coordinates.getLongitude();
        int lat = coordinates.getLatitude();
        int rand = 0;

            for (int i = 0; i < 4; i++) {
                rand = (int) (Math.random() + height + longi + lat);
            }

        return (weather[rand % 4]);
    }
}
