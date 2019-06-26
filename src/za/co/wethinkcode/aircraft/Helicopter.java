package za.co.wethinkcode.aircraft;

import za.co.wethinkcode.weather.*;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name,coordinates);
    }

    public void updateConditions(){
        //do some stuff
        String weather = this.weatherTower.getWeather(this.coordinates);
        if(weather.equals("RAIN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,this.coordinates.getLatitude(), this.coordinates.getHeight());
            //write to file
        }
        else if(weather.equals("SUN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 10,this.coordinates.getHeight() + 2);
            //write to file
        }
        else if(weather.equals("FOG")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,this.coordinates.getLatitude(),this.coordinates.getHeight() - 12);
            //write to file
        }
        else if(weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
        }
        //write to file that signal lost
    }

    public void registerTower(WeatherTower weatherTower){
        //do some stuff
        this.weatherTower = weatherTower;
        //write to file

        weatherTower.register(this);
    }
}
