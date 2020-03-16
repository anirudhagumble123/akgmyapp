package com.mphasis.akg.auth.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.akg.auth.model.Document;

@Service
public interface DocumentService {
	 void save(Document document);
	
	  public Document storeFile(MultipartFile file) throws IOException;
	  
	 
    }

	/*
	 * Document findByDocumentname(String documentname);
	 */	 


