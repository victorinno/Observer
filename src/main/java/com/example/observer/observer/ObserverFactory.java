package com.example.observer.observer;

import com.example.observer.adapter.MetaDataAdapterObserver;
import com.example.observer.encrypter.SHA256EncrypterObserver;
import com.example.observer.persister.JsonPersisterObserver;
import com.example.observer.reader.Mp3ReaderSubject;
import com.example.observer.repository.MetaDataRepositoryObserver;
import com.example.observer.repository.MetadataRepository;
import com.example.observer.writter.JsonWritterObserver;

public class ObserverFactory {

    public static SHA256EncrypterObserver sha256Encrypter() {
        return new SHA256EncrypterObserver();
    }

    public static MetaDataAdapterObserver metaDataAdapterObserver() {
        return new MetaDataAdapterObserver();
    }

    public static JsonPersisterObserver jsonPersister() {
        return new JsonPersisterObserver();
    }

    public static Mp3ReaderSubject mp3ReaderSubject() {
        return new Mp3ReaderSubject();
    }

    public static JsonWritterObserver jsonWritterObserver() {
        return new JsonWritterObserver();
    }

    public static MetaDataRepositoryObserver metaDataRepositoryObserver(MetadataRepository metadataRepository) {
        return new MetaDataRepositoryObserver(metadataRepository);
    }

}
