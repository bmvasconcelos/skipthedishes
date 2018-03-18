package skip.api.controllers;

import skip.api.dao.CustomerDAO;
import skip.api.models.Customer;

public class CustomerController {	

	public void saveCustomer(Customer customer) {
		CustomerDAO customerDao = new CustomerDAO();
		customerDao.saveCustomer(customer);
	}
	
	public void authCustomer() {
		CustomerDAO customerDao = new CustomerDAO();
		customerDao.authCustomer();
	}
	
}
