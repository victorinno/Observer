package com.example.observer.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<D> {

    List<Observer<D>> observers = new ArrayList<>(10);

    public void add(Observer<D> o) {
        observers.add(o);
    }

    public void remove(Observer<D> o) {
        observers.remove(o);
    }

    public void notifyObservers(D d) {
        observers.forEach(o -> o.notify(d));
    }
}
