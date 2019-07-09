package Simulator;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.PrintWriter; 
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;

import Simulator.Vehicles.*;
import Simulator.Interfaces.*;
import Simulator.Weather.*;
//import Simulator.vehicles.AircraftFactory;

public class Simulator{
    private static WeatherTower weatherTower;
    public static PrintWriter pw = null;

    public static void main(String[] arg) throws InterruptedException {  
        try{
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            pw = new PrintWriter("SimulationOutput.txt");       
            
            String line = reader.readLine(); 
            if (line != null){
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                // pw.println(arg[0]); 
                
                if(simulations < 0){
                    pw.println("invalid simulations count" + simulations);    
                    System.exit(1);
                }
                // pw.println("simulations to go: " + simulations); 

                while ((line = reader.readLine()) != null){
                    // pw.println(line);
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0],line.split(" ")[1],
                        Integer.parseInt(line.split(" ")[2]),Integer.parseInt(line.split(" ")[3]),
                        Integer.parseInt(line.split(" ")[4]));
                        
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++){
                    weatherTower.changeWeather();
                }
            }
            reader.close();
            pw.close();
        }
            catch (FileNotFoundException e){
                System.out.println("Couldn't find file" + arg[0] + e);
            }catch (IOException e){
                System.out.println("There was an error while reading the file" + arg[0] + e);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Specify simulations file" + e);
            }finally {
                System.out.println("Simulation Complete");
            //     Logger.getLogger().close();
            }

            
    }
}