package za.co.wethinkcode.weather;
import za.co.wethinkcode.aircraft.AircraftFactory;
import za.co.wethinkcode.aircraft.Flyable;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;



public class Simulator {
    public static FileWriter logger;
    //initialize weather tower and array list of flyables

    public static void main(String[] args){
        String scenarioFile = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(scenarioFile))) {

            String line;
            if(line == br.readLine())
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(" ");
            }

            //make sure lines are not empty
            //save first number for simulation number
            //check its positive
            //read other lines
            //make flyables from aircraft factory and use info from line as input

            //if successful
           //  flyable.add(flyable);

            //register flyables on towers

            //change the weather for all simulations runs
//            int i = 0;
//            while(i < simulations){
//                weatherTower.changeWeather();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close the logger
        }

        System.out.println("Success...");
        //return (weather[rand]);
        System.out.println("getting there");
    }
}
