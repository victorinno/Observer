package com.example.observer.adapter;

import com.example.observer.entity.BaseMetaData;
import org.apache.tika.metadata.Metadata;

public interface Adapter<B extends BaseMetaData> {
    B convert(Metadata a);
}
