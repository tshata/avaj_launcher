package za.co.wethinkcode.aircraft;

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
        }
        else if(weather.equals("SUN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 10,this.coordinates.getHeight() + 2);
            //write to file
        }
        else if(weather.equals("FOG")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() + 1,this.coordinates.getHeight());
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
        try {
            if(this.coordinates.getHeight() == 0)
            {
                weatherTower.unregister(this);
                System.out.println("Jetplane#" + this.name + "(" + this.id + ")" + " has landed.");
            }
            System.out.println("Tower says: Jetplane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
            //Simulator.logger.close();
        }catch(Exception e){
            System.out.println(e);
        }

        weatherTower.register(this);
    }
}
