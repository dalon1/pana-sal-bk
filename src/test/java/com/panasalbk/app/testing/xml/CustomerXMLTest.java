package com.panasalbk.app.testing.xml;

import java.util.List;

import org.junit.Test;

import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.models.Customer;

import org.junit.Assert;
import org.junit.Ignore;

public class CustomerXMLTest {
	
	@Test
	public void readCustomerTemplateXMLSuccess() {
		List<Customer> customers = CustomerRepository.getCustomerList();
		Assert.assertEquals(4, customers.size());
		Assert.assertEquals("Dannel", customers.get(0).getCustomerName().getFirstName());
		Assert.assertEquals("Alon", customers.get(0).getCustomerName().getLastName());
		Assert.assertEquals("dalon@cibc.com", customers.get(0).getEmailAddress());
		Assert.assertEquals("dalon", customers.get(0).getPassword());
	}
}
