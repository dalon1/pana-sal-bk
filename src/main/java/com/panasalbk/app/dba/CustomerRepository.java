package com.panasalbk.app.dba;

import java.util.*;
import com.panasalbk.app.annotations.WrittenBy;
import com.panasalbk.app.models.Customer;
import com.panasalbk.app.models.CustomerName;

/**
 * Customer Repository Class.
 * Simulate a fake Database. Only for convenience purposes.
 * @author AloniD
 */
@WrittenBy(
		author="Dannel Alon",
		date="26/03/2017",
		comment="Simulate a fake Database. XML templates will replace this soon.")
public class CustomerRepository {

	private static ArrayList<Customer> listCust = new ArrayList<Customer>() {{
		add(mockCustomer("Dannel", "Alon", "dalon@cibc.com", "dalon"));
		add(mockCustomer("Joel", "Alon", "joel@gmail.com", "password"));
		add(mockCustomer("Eitan", "Alon", "eitan@gmail.com", "password"));
		add(mockCustomer("Cloe", "Alonita", "cloe@gmail.com", "cloe64"));
	}};
	
	public static List<Customer> getCustomers() {
		return listCust;
	}
	
	private static Customer mockCustomer(String firstName, String lastName, String emailAddress, String password) {
		Customer customer = new Customer();
		CustomerName customerName = new CustomerName();
		customerName.setFirstName(firstName);
		customerName.setLastName(lastName);
		customer.setCustomerName(customerName);
		customer.setEmailAddress(emailAddress);
		customer.setPassword(password);
		return customer;
	}
}
