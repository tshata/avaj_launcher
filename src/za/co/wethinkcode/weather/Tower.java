package za.co.wethinkcode.weather;

import za.co.wethinkcode.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        //do some stuff
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){
        //do some stuff
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        //do some stuff
        int i = 0;

        while(i < observers.size())
        {
            observers.get(i).updateConditions();
            i++;
        }
    }
}
