package com.example.observer.repository;

import com.example.observer.entity.MetaDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<MetaDataEntity, Long> {

}
