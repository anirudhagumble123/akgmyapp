package com.mphasis.akg.auth.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mphasis.akg.auth.model.Document;


@Component
public class DocumentValidator implements Validator 
{

	@Override
	public boolean supports(Class<?> clazz) {
		 return Document.class.equals(clazz);
		
	}

	@Override
	public void validate(Object o, Errors errors) {
		Document document = (Document) o;
		
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documentname", "NotEmpty");
	        if (document.getDocumentname().length() < 6 || document.getDocumentname().length() > 32) {
	            errors.rejectValue("documentname", "Size.documentForm.documentname");
	        }
		
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documenttype", "NotEmpty");
	        if (document.getDocumenttype().length() < 6 || document.getDocumenttype().length() > 32) {
	            errors.rejectValue("documenttype", "Size.documentForm.documenttype");
	        }
	        
	}

}
