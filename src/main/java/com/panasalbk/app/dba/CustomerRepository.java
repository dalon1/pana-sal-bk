package com.panasalbk.app.dba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import com.panasalbk.app.util.XMLUtils;
import com.panasalbk.app.xml.engine.CustomerXML;
import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.CustomerName;

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

	@Deprecated
	private static ArrayList<Customer> listCust = new ArrayList<Customer>() {{
		add(mockCustomer("Dannel", "Alon", "dalon@cibc.com", "dalon"));
		add(mockCustomer("Joel", "Alon", "joel@gmail.com", "password"));
		add(mockCustomer("Eitan", "Alon", "eitan@gmail.com", "password"));
		add(mockCustomer("Cloe", "Alonita", "cloe@gmail.com", "cloe64"));
	}};
	
	@Deprecated
	public static List<Customer> getCustomers() {
		return listCust;
	}
	
	public static List<Customer> getCustomerList() {
		File file = XMLUtils.createFile(Templates.getCustomerPath());
		Document doc = XMLUtils.parseDocument(file);
		return new CustomerXML().retrieveList(doc);
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
