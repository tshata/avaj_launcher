package za.co.wethinkcode.weather;

import za.co.wethinkcode.aircraft.Coordinates;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates){
        //return WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return ("one");
    }

    void changeWeather(){
        this.conditionsChanged();
    }
}
