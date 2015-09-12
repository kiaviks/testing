package net.szecc.client.registration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Controller
public class BasicCustomerValidator implements Validator {
	
	private static Logger LOG = Logger.getLogger(BasicCustomerValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		LOG.info("entered customer validator");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "mandatory", "The nickName is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "mandatory", "The email is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "mandatory", "The password is mandatory");
		
		Customer customer = (Customer)target;
		
		if (customer.getNickName().contains(" ")) {
			//this reject a wrong field
			errors.rejectValue("nickName", "forbiddenchars", "please do not use spaces");
			
			//this reject the whole Bean (cannot be associated with a single field)
			//errors.reject("forbiddenchars", "please do not use spaces");
		}
		
	}

	
	
}
