package Simulator.Vehicles;

import Simulator.Simulator;
import Simulator.Weather.WeatherTower;
import Simulator.Weather.WeatherProvider;
import Simulator.Interfaces.Flyable;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public Baloon(String type,String name, Coordinates coordinates){
        super(type,name, coordinates);
    }

public void updateConditions(){

    int olatitude = this.coordinates.getLatitude();
    int olongitude = this.coordinates.getLongitude();
    int oheight = this.coordinates.getHeight();

    String weather = weatherTower.getWeather(this.coordinates);
    switch(weather){
        case "SUN": 
            this.coordinates = new Coordinates((olongitude =+ 2), olatitude, (oheight += 4));
             Simulator.pw.println("Baloon#" + this.name + "(" + id + "): " + "The Sun turned my baloon into one hot thing.");
            break;
        case "RAIN":
            this.coordinates = new Coordinates((olongitude += 5), olatitude, oheight);
            Simulator.pw.println("Baloon#" + this.name + "(" + id + "): " + "Rain down on my baloon.");
            break;
        case "FOG": 
            this.coordinates =  new Coordinates((olongitude += 3), olatitude, oheight);
            Simulator.pw.println("Baloon#" + this.name + "(" + id + "): " + "Can't see my baloon cause of the fog.");
            break;
        case "SNOW":
            this.coordinates = new Coordinates(olongitude, olatitude, (oheight += 15));
            Simulator.pw.println("Baloon#" + this.name + "(" + id + "): " + "Its snowing.We're gonna crash.");
            break;
        // case "Tower":
        //     this.coordinates = new Coordinates(olongitude,olatitude,(oheight += 1));
        //     Simulator.pw.println("Tower:" + "Baloon#" + this.name + "(" + id + "): " +"unregister from weather tower.");
        //     break;
        default:
            System.out.println("Not allowed");
    }

        if (this.coordinates.getHeight() <= 0) {
            Simulator.pw.println("Baloon#" + this.name + "(" + id + "): " + "Baloon unregistered from Tower." + this.coordinates.getLongitude() +" longitude: " + this.coordinates.getLatitude() + "latitude: " + " height:0");
            weatherTower.unregister(this);
        }
    }
    
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        Simulator.pw.println("Tower say: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}