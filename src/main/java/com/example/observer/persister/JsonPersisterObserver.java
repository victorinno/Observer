package com.example.observer.persister;

import com.example.observer.events.Event;
import com.example.observer.observer.Observer;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JsonPersisterObserver implements Observer<Event>, Persister {
    @Override
    public void persist(byte[] data, String path) {
        try {
            FileUtils.writeByteArrayToFile(new File(path), data);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void notify(Event event) {
        persist(event.getData(), event.getTo());
    }
}
