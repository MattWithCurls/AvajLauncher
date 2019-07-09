package Simulator.Vehicles;

import Simulator.Simulator;
import Simulator.Interfaces.Flyable;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        if (longitude < 0 && latitude < 0 && height < 0) {
            System.out.println(" Aircraft cannot be created due to invalid arguments ");
            return null;
        }

        Coordinates coordinates = new Coordinates(longitude,latitude,height);
        
        if (type.equalsIgnoreCase("baloon")){
            return new Baloon(type,name,coordinates);
        }
        else if (type.equalsIgnoreCase("helicopter"))
        {
            return new Helicopter(type,name,coordinates);
        }
        else if (type.equalsIgnoreCase("jetplane"))
        {
            return new JetPlane(type,name,coordinates);
        } else {
            return null;
        }
    }
}