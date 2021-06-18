package com.example.observer.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
public class MetaDataEntity extends BaseMetaData {
    @Id
    @GeneratedValue
    private Long id;
    private String header;
    private String title;
    private String artists;
    private String album;
    private String year;
    private String comment;
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Map<String, String> getProperties() {
        return Arrays.stream(this.getClass().getDeclaredFields()).collect(Collectors.toMap(Field::getName, f -> {
            try {
                return Optional.ofNullable(f.get(this)).map(Object::toString).orElse("");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        }));
    }
}
