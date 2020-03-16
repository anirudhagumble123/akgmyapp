package com.mphasis.akg.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.akg.auth.model.Document;

@Repository

public interface DocumentRepository extends JpaRepository<Document, Long> {
	/*
	 * Document findByDocumentname(String documentname);
	 */}
