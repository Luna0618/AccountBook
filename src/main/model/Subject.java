package model;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }


    public void notifyObserver(String category, int amount) {
        for (Observer o: observers) {
            o.update(category,amount);
        }
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }



}
