package com.mphasis.akg.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mphasis.akg.auth.model.Document;
import com.mphasis.akg.auth.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
    private DocumentRepository documentRepository;
    
	
	@Override
	public void save(Document document) {
		documentRepository.save(document);
		
	}

	/*
	 * @Override public Document findByDocumentname(String documentname) { return
	 * documentRepository.findByDocumentname(documentname); }
	 */
}
