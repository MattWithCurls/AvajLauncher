package Simulator.Weather;

import Simulator.Simulator;
import Simulator.Interfaces.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private ArrayList <Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if(!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable observer : observers){
            observer.updateConditions();
       
        }
    }
}