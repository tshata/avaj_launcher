package za.co.wethinkcode.aircraft;

import za.co.wethinkcode.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        //do some stuff
    }

    public void registerTower(WeatherTower weatherTower){
        //do some stuff
    }
}
