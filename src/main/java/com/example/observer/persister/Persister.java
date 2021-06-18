package com.example.observer.persister;

public interface Persister {
    void persist(byte[] data, String path);
}
