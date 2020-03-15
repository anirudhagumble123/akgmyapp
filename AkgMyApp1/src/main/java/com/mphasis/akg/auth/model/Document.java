package com.mphasis.akg.auth.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "document")
public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentname;
    
    private String documenttype;

    private String country;
    
    private String documentdate;
   
    // Upload files.
	/*
	 * private MultipartFile[] fileDatas;
	 */
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentname() {
		return documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public String getDocumenttype() {
		return documenttype;
	}

	public void setDocumenttype(String documenttype) {
		this.documenttype = documenttype;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDocumentdate() {
		return documentdate;
	}

	public void setDocumentdate(String documentdate) {
		this.documentdate = documentdate;
	}


	/*
	 * public MultipartFile[] getFileDatas() { return fileDatas; }
	 * 
	 * public void setFileDatas(MultipartFile[] fileDatas) { this.fileDatas =
	 * fileDatas; }
	 * 
	 */
    
}
