package com.example.service;

import com.example.entity.ElectionDocumentEntity;
import com.example.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectionsDocService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<String> getAllDocByType(String documentType) {
        return documentRepository.findAllByDocumentType(documentType)
                .stream()
                .map(ElectionDocumentEntity::getDocumentUrl)
                .collect(Collectors.toList());
    }
}
