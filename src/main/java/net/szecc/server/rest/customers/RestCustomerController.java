package net.szecc.server.rest.customers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.szecc.client.registration.UserType;
import net.szecc.server.rest.customers.model.RestCustomer;
import net.szecc.server.rest.customers.model.RestCustomerList;

@Controller
public class RestCustomerController {
	
	private static Logger LOG = Logger.getLogger(RestCustomerController.class);
	
	@RequestMapping(value="/rest/customers.do", method=RequestMethod.GET)
	public String getAllCustomers(Model model) {
		RestCustomerList customerList = new RestCustomerList();
		for (int i = 0; i < 10; i++) {
			RestCustomer customer = new RestCustomer();
			customer.setId(new Long(i));
			customer.setEmail("a" + i + "@b.it");
			customer.setNickName("nick" + i);
			customer.setPwd("******");
			customer.setUserType(UserType.STANDARD);
			customerList.getCustomers().add(customer);
		}
		model.addAttribute(customerList);
		return "customersTemplate";		
	}
	
	@RequestMapping(value="/rest/customers.do/{customerId}", method=RequestMethod.GET)
	public String getAllCustomers(
			@PathVariable("customerId") long customerId,
			Model model) {
		
		RestCustomer customer = new RestCustomer();
		customer.setId(customerId);
		customer.setEmail("a" + customerId + "@b.it");
		customer.setNickName("nick" + customerId);
		customer.setPwd("******");
		customer.setUserType(UserType.STANDARD);
		model.addAttribute(customer);
		return "customersTemplate";		
	}
	
	//Set the parser for Date values in request paths
	@InitBinder
	public void initDateBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
	
	@RequestMapping (value="/rest/customers.do/{dateFrom}/{dateTo}", method=RequestMethod.GET)
	public String getCustomerFromDateToDate(
			@PathVariable("dateFrom") Date dateFrom,
			@PathVariable("dateTo") Date dateTo,
			Model model
			) {
		
		Calendar calendarFrom = Calendar.getInstance();
		calendarFrom.setTime(dateFrom);
		Calendar calendarTo = Calendar.getInstance();
		calendarTo.setTime(dateTo);
		
		RestCustomerList customerList = getCustomerList(calendarFrom, calendarTo);
		model.addAttribute(customerList);
		
		return "customersTemplate";
	}
	
	public RestCustomerList getCustomerList(Calendar calendarFrom, Calendar calendarTo) {
		RestCustomerList customerList = new RestCustomerList();
		int i = 0;
		while (calendarFrom.compareTo(calendarTo) < 0) {
			RestCustomer customer = new RestCustomer();
			customer.setId(new Long(i));
			customer.setEmail("a" + i + "@b.it");
			customer.setNickName("nick" + i);
			customer.setPwd("******");
			customer.setUserType(UserType.STANDARD);
			customerList.getCustomers().add(customer);
			i++;
			calendarFrom.add(Calendar.DATE, 1);
		}
		return customerList;
	}
	
}
