package com.mphasis.akg.auth.service;

import org.springframework.stereotype.Service;

import com.mphasis.akg.auth.model.Document;

@Service
public interface DocumentService {
	 void save(Document document);

	/*
	 * Document findByDocumentname(String documentname);
	 */	 

}
