package za.co.wethinkcode.aircraft;

import za.co.wethinkcode.tools.Logger;
import za.co.wethinkcode.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower = new WeatherTower();

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        //do some stuff
        String weather = this.weatherTower.getWeather(this.coordinates);
        if(weather.equals("RAIN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
            //write to file
            Logger.getWriteFile().fileWriter("JetPLane#" + this.name + "(" + this.id + "):" + " Just fly above the clouds.");
        }
        else if(weather.equals("SUN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 10,this.coordinates.getHeight() + 2);
            //write to file
            Logger.getWriteFile().fileWriter("JetPlane#" + this.name + "(" + this.id + "):" + " Flip upside down so the sun won't blind you.");
        }
        else if(weather.equals("FOG")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 1,this.coordinates.getHeight());
            //write to file
            Logger.getWriteFile().fileWriter("JetPlane#" + this.name + "(" + this.id + "):" + " We don't care we just make sonic booms through this fog.");
        }
        else if(weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            Logger.getWriteFile().fileWriter("JetPlane#" + this.name + "(" + this.id + "):" + " Get cruising altitude.");
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
                Logger.getWriteFile().fileWriter("Jetplane#" + this.name + "(" + this.id + ")" + " has landed.");
            }
            Logger.getWriteFile().fileWriter("Tower says: Jetplane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
            //Simulator.logger.close();
        }catch(Exception e){
            System.out.println(e);
        }

        weatherTower.register(this);
    }
}
