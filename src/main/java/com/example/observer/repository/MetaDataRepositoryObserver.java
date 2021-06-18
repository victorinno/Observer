package com.example.observer.repository;

import com.example.observer.entity.MetaDataEntity;
import com.example.observer.events.Event;
import com.example.observer.observer.SubjectObserver;

public class MetaDataRepositoryObserver extends SubjectObserver<Event> {

    private MetadataRepository metadataRepository;

    public MetaDataRepositoryObserver(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    @Override
    public void notify(Event event) {
        MetaDataEntity metaDataEntity = event.getMetaDataEntity();
        this.metadataRepository.saveAndFlush(metaDataEntity);
    }
}
