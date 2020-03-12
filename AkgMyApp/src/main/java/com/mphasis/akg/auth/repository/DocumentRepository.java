package com.mphasis.akg.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.akg.auth.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document findByDocumentname(String documentname);
}
