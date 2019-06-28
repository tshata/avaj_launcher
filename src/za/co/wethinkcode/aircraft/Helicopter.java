package za.co.wethinkcode.aircraft;

import za.co.wethinkcode.weather.*;

import java.io.FileWriter;

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
            System.out.print("Helicopter#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("It is raining, lets head east.");
        }
        else if(weather.equals("SUN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 10,this.coordinates.getHeight() + 2);
            //write to file
            System.out.print("Helicopter#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("Don't look at the sun");
        }
        else if(weather.equals("FOG")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,this.coordinates.getLatitude(),this.coordinates.getHeight() - 12);
            //write to file
            System.out.print("Helicopter#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("I can't see sh*t");
        }
        else if(weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            System.out.print("Helicopter#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("It is snowing, lets land.");
        }
        //write to file that signal lost
    }

    public void registerTower(WeatherTower weatherTower){
        //do some stuff
        this.weatherTower = weatherTower;
        //write to file
        try {
            if(this.coordinates.getHeight() == 0)
            {
                weatherTower.unregister(this);
                System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " has landed.");
            }

                System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
                weatherTower.register(this);
        }catch(Exception e){
            System.out.println(e);
        }
        weatherTower.register(this);
    }
}
