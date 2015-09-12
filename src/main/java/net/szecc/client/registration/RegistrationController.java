package net.szecc.client.registration;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//@SessionAttributes("customer")
public class RegistrationController {
	
	private static Logger LOG = Logger.getLogger(RegistrationController.class);
	private CustomerService customerService;
	private BasicCustomerValidator basicCustomerValidator;
	
	@Autowired
	public RegistrationController(
			CustomerService customerService,
			BasicCustomerValidator basicCustomerValidator) {
		this.customerService = customerService;
		this.basicCustomerValidator = basicCustomerValidator;
	}
	
	@RequestMapping(value="/newCustomer.do", method=RequestMethod.GET)
	public String openNewCustomer(
			@ModelAttribute Customer customer,
			Model model) {
		model.addAttribute("customer",customer);
		return "forward:/pages/newCustomer";
	}
	
	@RequestMapping(value="/newCustomer.do", method=RequestMethod.POST)
	public String saveCustomer(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult,
			Model model,
			HttpSession session,
			SessionStatus sessionStatus
			) {
		basicCustomerValidator.validate(customer, bindingResult);
		if (bindingResult.hasErrors()) {
			LOG.error("unexpected customer values");
			model.addAttribute("customer", customer);
			for ( ObjectError oe : bindingResult.getAllErrors() ) {
				for ( String o : oe.getCodes() ) {
					LOG.warn(o);
				}
			}
			return "newCustomer";
		}
		
		LOG.info("persisting customer " + customer.getNickName());
		customerService.save(customer);
		session.setAttribute("customer", customer);
		
//		if (true)
//			throw new RuntimeException("testexc");
		
		return "redirect:/pages/private/welcome";
//		return "welcomeRedirect";
	}
	
	@ModelAttribute("userTypes")
	public List<UserType> getUserTypes() {
		return Arrays.asList(UserType.values());
	}
	
}
