package za.co.wethinkcode.weather;
import za.co.wethinkcode.aircraft.AircraftFactory;
import za.co.wethinkcode.aircraft.Flyable;
import java.io.*;
import java.util.*;



public class Simulator {
   private static WeatherTower weatherTower;
    public static FileWriter logger;
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    //initialize weather tower and array list of flyables

    public static void main(String[] args){
       // AircraftFactory aircraftFactory = new AircraftFactory;
        String scenarioFile = args[0];
      //  WeatherTower weatherTower;
        try (BufferedReader br = new BufferedReader(new FileReader(scenarioFile))) {

            String line;

            if((line = br.readLine()) != null)
            {
                int simu = Integer.parseInt(line);
                System.out.println(simu);
                if(simu > 0)
                {
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(" ");

                        String part1 = parts[0];
                        String part2 = parts[1];
                        String part3 = parts[2];
                        String part4 = parts[3];
                        String part5 = parts[4];

                        int longit = Integer.parseInt(part3);
                        int latitu = Integer.parseInt(part4);
                        int height = Integer.parseInt(part5);

                        System.out.print(part1 + " ");
                        System.out.print(part2 + " ");
                        System.out.print(part3 + " ");
                        System.out.print(part4 + " ");
                        System.out.print(part5 + "\n");
                        Flyable flyable = AircraftFactory.newAircraft(part1, part2, longit, latitu, height);
                        if(flyable != null)
                        {
                            flyables.add(flyable);
                        }
//                        System.out.println(line);
                        //loop through arraylist of flyables
//                        while(flyables != null) {
//                            flyable.registerTower(weatherTower);
//                        }

                        for (Flyable f : flyables)
                        {
                            if(f == null)
                                break;
                            System.out.println(f);
                            f.registerTower(weatherTower);
                        }


                        int j = 0;
                        while(j < simu)
                        {
                            weatherTower.changeWeather();
                            j++;
                        }
                    }
                }


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
