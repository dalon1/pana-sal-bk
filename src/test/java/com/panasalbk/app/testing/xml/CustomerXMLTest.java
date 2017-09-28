package com.panasalbk.app.testing.xml;

import java.util.List;

import org.junit.Test;

import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.model.Customer;

import org.junit.Assert;
import org.junit.Ignore;

public class CustomerXMLTest {
	
	@Test
	public void readCustomerTemplateXMLSuccess() {
		List<Customer> customers = CustomerRepository.getCustomerList();
		Assert.assertEquals(4, customers.size());
		Assert.assertEquals("100", customers.get(0).getId().getId().toString());
		Assert.assertEquals("Dannel", customers.get(0).getCustomerName().getFirstName());
		Assert.assertEquals("Alon", customers.get(0).getCustomerName().getLastName());
		Assert.assertEquals("dalon@cibc.com", customers.get(0).getEmailAddress());
		Assert.assertEquals("dalon", customers.get(0).getPassword());
		Assert.assertEquals("Dannel Alon", customers.get(0).getCustomerName().getFullName());
	}
	
	@Test
	public void readCustomerTemplateWithMiddleNameXMLSuccess() {
		List<Customer> customers = CustomerRepository.getCustomerList();
		Assert.assertEquals(4, customers.size());
		Assert.assertEquals("200", customers.get(1).getId().getId().toString());
		Assert.assertEquals("Joel", customers.get(1).getCustomerName().getFirstName());
		Assert.assertEquals("Israel", customers.get(1).getCustomerName().getMiddleName());
		Assert.assertEquals("Alon", customers.get(1).getCustomerName().getLastName());
		Assert.assertEquals("Joel Israel Alon", customers.get(1).getCustomerName().getFullName());
		Assert.assertEquals("joel@gmail.com", customers.get(1).getEmailAddress());
		Assert.assertEquals("password", customers.get(1).getPassword());
	}
}
