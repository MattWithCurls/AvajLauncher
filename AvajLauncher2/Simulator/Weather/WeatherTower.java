package Simulator.Weather;

import Simulator.Vehicles.Coordinates;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        this.conditionsChanged();
    }
}