package com.example.observer.events;

import com.example.observer.entity.MetaDataEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.tika.metadata.Metadata;

@Getter
@Setter
@Builder
public class Event {

    private String from;
    private String to;
    private byte[] data;
    private MetaDataEntity metaDataEntity;
    private Metadata metadata;

}
