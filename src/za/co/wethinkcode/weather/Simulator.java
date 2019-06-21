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
        System.out.println("This should work");
    }
}
