    package za.co.wethinkcode.weather;
    import za.co.wethinkcode.aircraft.AircraftFactory;
    import za.co.wethinkcode.aircraft.Flyable;
    import za.co.wethinkcode.tools.Logger;

    import java.io.*;
    import java.util.*;



    public class Simulator {
       private static WeatherTower weatherTower = new WeatherTower();

        private static List<Flyable> flyables = new ArrayList<Flyable>();
        //initialize weather tower and array list of flyables

        public static void main(String[] args) {
            // AircraftFactory aircraftFactory = new AircraftFactory;
            if(args[0] == null)
            {
                System.out.println("You must include a scenario file as input to the program when you run it.");
            }
            String scenarioFile = args[0];
            //  WeatherTower weatherTower;
            try (BufferedReader br = new BufferedReader(new FileReader(scenarioFile))) {

                String line;

                if ((line = br.readLine()) != null) {
                    int simu = Integer.parseInt(line);
                 //   System.out.println(simu);
                    if (simu > 0) {
                        while ((line = br.readLine()) != null) {
                            if(line.length() == 32)
                            {
                                System.out.println("I can't read encrypted files");
                            }
                            String[] parts = line.split(" ");

                            String part1 = parts[0];
                            String part2 = parts[1];
                            String part3 = parts[2];
                            String part4 = parts[3];
                            String part5 = parts[4];
                              int longit = Integer.parseInt(part3);
                            int latitu = Integer.parseInt(part4);
                            int height = Integer.parseInt(part5);

             if(latitu < 0 || longit < 0 || height < 0){
           System.out.println("Error : All values must be positive");
             break;
           }

                            Flyable flyable = AircraftFactory.newAircraft(part1, part2, longit, latitu, height);
                            if(flyable != null)
                            {
                                flyables.add(flyable);
                            }

                            flyable.registerTower(weatherTower);

                        }
                       int j = 0;
                        while (j < simu) {
                            weatherTower.changeWeather();
                            j++;
                        }
                    }else
                        System.out.println("There should be a positive number at the top of the scenario file");


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
    //             int i = 0;
    //            while(i < simu){
    //                weatherTower.changeWeather();
    //            }
            } catch (IOException e) {
    System.out.println("There was an error reading the file.");
            } finally {
    //            //close the logger
                Logger.getWriteFile().close();
            }

           //     System.out.println("Success...");
                //return (weather[rand]);
           //     System.out.println("getting there");
            }
        }
