package com.example.observer.observer;

import com.example.observer.entity.MetaDataEntity;

public class NullObserver implements Observer<MetaDataEntity> {
    @Override
    public void notify(MetaDataEntity d) {
        // does nothing
    }
}
