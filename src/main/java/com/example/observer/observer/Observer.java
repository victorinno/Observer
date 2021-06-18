package com.example.observer.observer;

public interface Observer<D> {

    void notify(D d);
}
