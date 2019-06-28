package za.co.wethinkcode.aircraft;

import za.co.wethinkcode.tools.Logger;
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
            if(this.coordinates.getHeight() == 0)
            {

                weatherTower.unregister(this);
                try {
                    FileWriter fw= new FileWriter("simulation.txt");
                    fw.write("Baloon#" + this.name + "(" + this.id + ")" + " has landed.");
                }catch (Exception e){
                    System.out.println("Error writing to file.");
                }
            }
            try {
                FileWriter fw= new FileWriter("simulation.txt");
               fw.write("Baloon#:" + this.name + "(" + this.id + ")" + " says: ");
                fw.write("It is raining, we need to go lower");
            }catch (Exception e)
            {
                System.out.println("Error writing to file.");
            }

        } else if (weather.equals("SUN") ){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            //write to file
            System.out.print("Baloon#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("Its a sunny day");
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() + 3);
            //write to file
            if(this.coordinates.getHeight() == 0)
            {
                weatherTower.unregister(this);
                System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " has landed.");
            }
            System.out.print("Baloon#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("There's something in the mist!!!");
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            if(this.coordinates.getHeight() == 0)
            {
                weatherTower.unregister(this);
                System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " has landed.");
            }
            System.out.print("Baloon#:" + this.name + "(" + this.id + ")" + " says: ");
            System.out.println("It is snowing, we need to land");

        }
    }   //write to file that signal lost
    public void registerTower(WeatherTower weatherTower){
        //do some stuff
        this.weatherTower = weatherTower;
        //write to file
        try {
            if(this.coordinates.getHeight() == 0)
            {
                weatherTower.unregister(this);
               System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " has landed.");
            }
            try{
            //    FileWriter fw= new FileWriter("simulation.txt");
                Logger.getWriteFile().writetofile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
                weatherTower.register(this);
               Logger.getWriteFile().close();
            }catch (Exception e){
                System.out.println("Error writing to file");
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
