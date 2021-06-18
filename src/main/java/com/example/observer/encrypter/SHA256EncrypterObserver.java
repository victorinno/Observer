package com.example.observer.encrypter;

import com.example.observer.events.Event;
import com.example.observer.observer.SubjectObserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256EncrypterObserver extends SubjectObserver<Event> implements Encrypter {
    @Override
    public void notify(Event event) {
        byte[] data = event.getData();
        event.setData(encrypt(data));
        notifyObservers(event);
    }

    @Override
    public byte[] encrypt(byte[] data) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
