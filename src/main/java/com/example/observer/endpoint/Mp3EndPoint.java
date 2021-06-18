package com.example.observer.endpoint;

import com.example.observer.adapter.MetaDataAdapterObserver;
import com.example.observer.encrypter.SHA256EncrypterObserver;
import com.example.observer.events.Event;
import com.example.observer.persister.JsonPersisterObserver;
import com.example.observer.reader.Mp3ReaderSubject;
import com.example.observer.repository.MetaDataRepositoryObserver;
import com.example.observer.repository.MetadataRepository;
import com.example.observer.writter.JsonWritterObserver;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class Mp3EndPoint {

    private MetadataRepository metadataRepository;

    public Mp3EndPoint(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    @PostMapping("/mp3")
    public Response equals(@RequestBody Mp3Parameters mp3Parameters) {
        Mp3ReaderSubject mp3ReaderSubject = new Mp3ReaderSubject();
        MetaDataAdapterObserver metaDataAdapterObserver = new MetaDataAdapterObserver();
        mp3ReaderSubject.add(metaDataAdapterObserver);
        MetaDataRepositoryObserver metaDataRepositoryObserver = new MetaDataRepositoryObserver(metadataRepository);
        JsonWritterObserver jsonWritterObserver = new JsonWritterObserver();
        metaDataAdapterObserver.add(metaDataRepositoryObserver);
        metaDataAdapterObserver.add(jsonWritterObserver);
        SHA256EncrypterObserver sha256EncrypterObserver = new SHA256EncrypterObserver();
        jsonWritterObserver.add(sha256EncrypterObserver);
        JsonPersisterObserver jsonPersister = new JsonPersisterObserver();
        sha256EncrypterObserver.add(jsonPersister);
        mp3ReaderSubject.read(Event.builder().from(mp3Parameters.getFrom()).to(mp3Parameters.getTo()).build());
        return Response.ok().build();
    }
}
