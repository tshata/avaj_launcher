package za.co.wethinkcode.weather;

import za.co.wethinkcode.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        //do some stuff
        if(observers.contains(flyable))
            return;
         //   System.exit(0);
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){
        //do some stuff
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        //do some stuff

        int i = 0;

        //check height at 0 for those landed
        while(i < observers.size())
        {
//System.out.println(i);
            observers.get(i).updateConditions();
            i++;

        }


        //remove landed

    }
}
