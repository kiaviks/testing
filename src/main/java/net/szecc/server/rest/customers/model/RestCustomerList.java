package net.szecc.server.rest.customers.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestCustomerList {
	
	private List<RestCustomer> customers;
	
	public RestCustomerList() {
		this.customers = new ArrayList<RestCustomer>();
	}
	
	public List<RestCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<RestCustomer> customers) {
		this.customers = customers;
	}

}
