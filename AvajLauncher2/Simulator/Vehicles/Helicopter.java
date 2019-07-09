package Simulator.Vehicles;

import Simulator.Simulator;
import Simulator.Weather.WeatherTower;
import Simulator.Interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public Helicopter(String type,String name, Coordinates coordinates)
    {
        super(type,name, coordinates);
    }
    public void updateConditions(){

        int olatitude = this.coordinates.getLatitude();
        int olongitude = this.coordinates.getLongitude();
        int oheight = this.coordinates.getHeight();

        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN": 
                this.coordinates = new Coordinates((olongitude =+ 10), olatitude, (oheight += 2));
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "This is hot.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates((olongitude =+ 5), olatitude, oheight);
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "My rotor is going to freeze.");
                break;
            case "FOG": 
                this.coordinates =  new Coordinates((olongitude += 1), olatitude, oheight);
                Simulator.pw.println("Baloon#" + this.name + "(" + id + "): " + "CAn't see what is ahead of me.");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(olongitude, olatitude, (oheight += 12));
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "My rotor is going to freeze.");
                break;
            default:
                System.out.println("Not allowed");
        }

        if (this.coordinates.getHeight() <= 0) {
                Simulator.pw.println("Helicopter#" + this.name + "(" + id + "): " + "This Aircraft unregistered from Tower." + this.coordinates.getLongitude() +" longitude: " + this.coordinates.getLatitude() + "latitude: " + " height:0");
            weatherTower.unregister(this);
        }
                //return changeOfWeather;
            }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        Simulator.pw.println("Tower say: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}