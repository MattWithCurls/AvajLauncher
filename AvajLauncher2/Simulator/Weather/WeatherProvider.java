package Simulator.Weather;

import java.util.Random;

import Simulator.Simulator;
import Simulator.Vehicles.Coordinates;
public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"SUN","FOG","SNOW","RAIN"};

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        // return weather[2];
        int rando = (int) (Math.random() * 4);
        Simulator.pw.println(weather[rando]);
        return(weather[rando]);
    }
}