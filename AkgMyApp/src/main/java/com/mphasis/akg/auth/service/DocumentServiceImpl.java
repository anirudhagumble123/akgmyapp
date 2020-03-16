package com.mphasis.akg.auth.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.akg.auth.model.Document;
import com.mphasis.akg.auth.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private DocumentDao documentDao;

	@Override
	public void save(Document document) {
		documentRepository.save(document);


		System.out.println("file upload happening");
		
	}


  @Override public Document storeFile(MultipartFile file) throws IOException {
		
		  String documentname = StringUtils.cleanPath(file.getOriginalFilename());
		 
		  Document document = new Document(documentname, file.getContentType(),
		  file.getBytes());
		 
  
  return documentRepository.save(document); 
  } 
  }
  
  
 
/*
 * 
 * @Override public Document findByDocumentname(String documentname) { return
 * documentRepository.findByDocumentname(documentname); }
 */
