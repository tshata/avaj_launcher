package za.co.wethinkcode.aircraft;

import za.co.wethinkcode.weather.Simulator;
import za.co.wethinkcode.weather.WeatherTower;

import java.io.FileWriter;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() {
        //do some stuff
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equals("RAIN") ){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            //write to file
        } else if (weather.equals("SUN") ){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            //write to file
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() + 3);
            //write to file
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
        }
    }   //write to file that signal lost
    public void registerTower(WeatherTower weatherTower){
        //do some stuff
        this.weatherTower = weatherTower;
        //write to file
        try {
            Simulator.logger.write(this.name + this.id + " registered to " + this.weatherTower);
            Simulator.logger.close();
        }catch(Exception e){
            System.out.println(e);
        }
        weatherTower.register(this);
    }
}
