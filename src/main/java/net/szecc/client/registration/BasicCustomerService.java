package net.szecc.client.registration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicCustomerService implements CustomerService {
	
	private static Logger LOG = Logger.getLogger(BasicCustomerService.class);
	
	private CustomerDao customerDao;
	
//	@Autowired
//	public BasicCustomerService(CustomerDao customerDao) {
//		this.customerDao = customerDao;
//	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		
//		LOG.warn("**********************************************");
//		LOG.warn("Cannot save customer " + customer.getNickName() + "/" + customer.getEmail());
//		LOG.warn("Save method not implemented");
		
		customerDao.save(customer);
		
	}

}
