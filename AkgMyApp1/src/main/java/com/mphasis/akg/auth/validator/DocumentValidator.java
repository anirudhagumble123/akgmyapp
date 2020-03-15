package com.mphasis.akg.auth.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mphasis.akg.auth.model.Document;


@Component
public class DocumentValidator implements Validator 
{
	/*
	 * @Autowired private DocumentService documentService;
	 */
	
	@Override
	public boolean supports(Class<?> aClass) {
		 return Document.class.equals(aClass);
		
	}

	@Override
	public void validate(Object o, Errors errors) {
		Document document = (Document) o;
		
		/*
		 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documentname",
		 * "NotEmpty"); if (document.getDocumentname().length() < 6 ||
		 * document.getDocumentname().length() > 32) {
		 * errors.rejectValue("documentname", "Size.documentForm.documentname"); }
		 */
		/*
		 * if (documentService.findByDocumentname(document.getDocumentname()) != null) {
		 * errors.rejectValue("username", "Duplicate.userForm.username"); }
		 */
		/*
		 * ValidationUtils.rejectIfEmptyOrWhitespace(errors, "documenttype",
		 * "NotEmpty"); if (document.getDocumenttype().length() < 6 ||
		 * document.getDocumenttype().length() > 32) {
		 * errors.rejectValue("documenttype", "Size.documentForm.documenttype"); }
		 */
	        
	}

}
