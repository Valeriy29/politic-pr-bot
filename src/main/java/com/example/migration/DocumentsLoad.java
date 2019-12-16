package com.example.migration;

import com.example.entity.ElectionDocumentEntity;
import com.example.repository.DocumentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.constant.DocumentType.*;

@Service
public class DocumentsLoad {

    @Autowired
    private DocumentRepository documentRepository;

    public static List<ElectionDocumentEntity> loadElectionsDocuments() {
        return Lists.newArrayList(
//                new ElectionDocumentEntity(null, PARLIAMENT_ELECTIONS.getDocType(), "Accounts", "https://drive.google.com/open?id=0B2envDjESX6bYi16cG9iUDNEVzViT0hGV2NBenREZVFQTXNz"),
//                new ElectionDocumentEntity(null, PARLIAMENT_ELECTIONS.getDocType(), "Instruction", "https://drive.google.com/open?id=0B2envDjESX6bc2RFYk51S0cwQ3pmdVJmNVlBemRtMjJoVEFZ"),
//                new ElectionDocumentEntity(null, PARLIAMENT_ELECTIONS.getDocType(), "Appendix to instruction", "https://drive.google.com/open?id=0B2envDjESX6bc0R2S204SjUyQnJMMUwyN2IxLWpvYjJENS00"),
//                new ElectionDocumentEntity(null, PARLIAMENT_ELECTIONS.getDocType(), "Сandidate registration", "https://drive.google.com/open?id=0B2envDjESX6bRGpiNkdHY3RVWVpNTFpjQzNvNkZNTXhHYTJV"),
//                new ElectionDocumentEntity(null, PARLIAMENT_ELECTIONS.getDocType(), "Union registration", "https://drive.google.com/open?id=0B2envDjESX6bdGxiQUNNazQwdTYxUkhIVXRJcnF4bVI2YURJ"),
//                new ElectionDocumentEntity(null, REGION_ELECTIONS.getDocType(), "Accounts", "https://drive.google.com/open?id=0B2envDjESX6bZHExWkRBbS1wV2Zud1BBNkJDSS1FZGlydFhz"),
//                new ElectionDocumentEntity(null, REGION_ELECTIONS.getDocType(), "Instruction", "https://drive.google.com/open?id=0B2envDjESX6bQVhBQ3ZsaFRtc1MySWZqLTJVVE5jVkYweXVF"),
//                new ElectionDocumentEntity(null, REGION_ELECTIONS.getDocType(), "Forms", "https://drive.google.com/open?id=0B2envDjESX6bQlJLRTdLZzBmbkF6OGFyTWlDaGNxS2lXd0pZ"),
//                new ElectionDocumentEntity(null, REGION_ELECTIONS.getDocType(), "Forms and app", "https://drive.google.com/open?id=0B2envDjESX6bUnBJNmFyZERMaHhzT0lmVFZxSTQzZHB1WU9r")
                new ElectionDocumentEntity(null, BRIEF.getDocType(), "Brief dev project", "https://drive.google.com/open?id=0B2envDjESX6bbXo5V0tZQ3pBcGdlQkpJRi1GcTF2OXp4MWEw"),
                new ElectionDocumentEntity(null, COMMERCIAL.getDocType(), "Commercial offer", "https://drive.google.com/open?id=0B2envDjESX6bcFpVWUJoTWo4UXFqZXNOd3dHa3o4MERyRE1j")
        );
    }

    public void saveAllDocuments() {
        loadElectionsDocuments().forEach(electionsDoc -> documentRepository.save(electionsDoc));
    }

}
