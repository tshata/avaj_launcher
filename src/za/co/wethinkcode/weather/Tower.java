package za.co.wethinkcode.weather;

import za.co.wethinkcode.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        //do some stuff
    }
    public void unregister(Flyable flyable){
        //do some stuff
    }

    protected void conditionsChanged(){
        //do some stuff
    }
}
