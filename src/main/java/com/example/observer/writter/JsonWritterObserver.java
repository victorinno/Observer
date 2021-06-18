package com.example.observer.writter;

import com.example.observer.entity.MetaDataEntity;
import com.example.observer.events.Event;
import com.example.observer.observer.SubjectObserver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWritterObserver extends SubjectObserver<Event> implements Writter<MetaDataEntity> {
    @Override
    public void notify(Event event) {
        byte[] bytes = write(event.getMetaDataEntity());
        event.setData(bytes);
        notifyObservers(event);
    }

    @Override
    public byte[] write(MetaDataEntity m) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsBytes(m);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
