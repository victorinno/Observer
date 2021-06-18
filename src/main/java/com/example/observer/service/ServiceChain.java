package com.example.observer.service;


public abstract class ServiceChain {

    private ServiceChain next;

    public ServiceChain(ServiceChain next) {
        this.next = next;
    }


}
