package za.co.wethinkcode.weather;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Simulator {
    public static void main(String[] args){
        String scenarioFile = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(scenarioFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String weather[] = {"RAIN", "FOG", "SNOW", "HAIL"};
        int rand = 0;


            for (int i = 0; i < 100; i++) {
                rand = (int) (Math.random() + 50 + 23 + 22);
            }

       // return (weather[rand]);
        System.out.println(rand % 4);
    }
}
