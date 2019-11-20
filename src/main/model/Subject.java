package model;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    //MODIFIES:this
    //EFFECTS: Add an observer to the list of observers
    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    //MODIFIES:this
    //EFFECTS:Update each observer in the list of observers
    public void notifyObserver(String category, int amount) {
        for (Observer o: observers) {
            o.update(category,amount);
        }
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }



}
