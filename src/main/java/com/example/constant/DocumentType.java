package com.example.constant;

public enum DocumentType {

    PARLIAMENT_ELECTIONS("Parliament"),
    REGION_ELECTIONS("Region");

    private String docType;

    DocumentType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }
}
