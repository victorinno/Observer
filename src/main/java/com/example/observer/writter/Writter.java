package com.example.observer.writter;

import com.example.observer.entity.BaseMetaData;

public interface Writter<M extends BaseMetaData> {
    byte[] write(M m);
}
