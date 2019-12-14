package com.example.repository;

import com.example.entity.ElectionDocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<ElectionDocumentEntity, Long> {

    List<ElectionDocumentEntity> findAllByDocumentType(String documentType);

}
