package Simulator.Vehicles;

import Simulator.Simulator;
import Simulator.Weather.WeatherTower;
import Simulator.Interfaces.Flyable;

import java.io.PrintWriter; 

public class JetPlane extends Aircraft implements Flyable{


    private WeatherTower weatherTower;

    public JetPlane(String type,String name, Coordinates coordinates){
        super(type,name, coordinates);
    }

    public void updateConditions(){
        
        int olatitude = this.coordinates.getLatitude();
        int olongitude = this.coordinates.getLongitude();
        int oheight = this.coordinates.getHeight();

        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                // Simulator.pw.write("Oi."); 
                this.coordinates = new Coordinates((olongitude =+ 10), olatitude, (oheight += 2));
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "OMG its hot.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates((olongitude =+ 5), olatitude, oheight);
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "It's raining.Better watch out for lightings.");
                break;
            case "FOG": 
                this.coordinates =  new Coordinates((olongitude =+ 1), olatitude, oheight);
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "Can't see landing zone.");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(olongitude, olatitude, (oheight += 7));
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
            default:
                System.out.println("Not allowed");
        }

        if (this.coordinates.getHeight() <= 0) {
            Simulator.pw.println("JetPlane#" + this.name + "(" + id + "): " + "JetPlane unregistered from Tower." + this.coordinates.getLongitude() +" longitude: " + this.coordinates.getLatitude() + "latitude: " + " height:0");
            weatherTower.unregister(this);
        }
                //return changeOfWeather;
    }
    public void registerTower(WeatherTower weatherTower){
        Simulator.pw.println("Tower say: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

}