package com.example.observer.adapter;

import com.example.observer.entity.MetaDataEntity;
import com.example.observer.events.Event;
import com.example.observer.observer.SubjectObserver;
import org.apache.tika.metadata.Metadata;

public class MetaDataAdapterObserver extends SubjectObserver<Event> implements Adapter<MetaDataEntity> {

    @Override
    public void notify(Event event) {
        MetaDataEntity metaDataEntity = convert(event.getMetadata());
        event.setMetaDataEntity(metaDataEntity);
        notifyObservers(event);
    }

    @Override
    public MetaDataEntity convert(Metadata metadata) {
        return MetaDataEntity.builder()
                .album(metadata.get("xmpDM:album"))
                .artists(metadata.get("xmpDM:artist"))
                .comment(metadata.get("xmpDM:logComment"))
                .genre(metadata.get("xmpDM:genre"))
                .header("TAG")
                .title(metadata.get("title"))
                .year(metadata.get("xmpDM:releaseDate"))
                .build();
    }
}
