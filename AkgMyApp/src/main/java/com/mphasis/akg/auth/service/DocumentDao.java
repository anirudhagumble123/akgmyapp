package com.mphasis.akg.auth.service;


import org.springframework.data.repository.CrudRepository;

import com.mphasis.akg.auth.model.Document;

public interface DocumentDao extends CrudRepository<Document, Long> {
    
}
