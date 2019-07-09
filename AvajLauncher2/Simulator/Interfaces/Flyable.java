package Simulator.Interfaces;

import Simulator.Simulator;
import Simulator.Weather.WeatherTower;

public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}