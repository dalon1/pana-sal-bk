package com.panasalbk.app.testing;

import com.panasalbk.app.models.Customer;
import com.panasalbk.app.models.CustomerName;
import com.panasalbk.app.models.Registration;
import com.panasalbk.app.providers.RegistrationProvider;
import com.panasalbk.app.testing.mocks.MockCustomer;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RegistrationTest {
	
	@Test
	public void testCustomerRegistrationSuccess() {
		Registration registration = mockRegistration("Bryan", "Maravilla", "bmaravilla@gmail.com", "password123");
		RegistrationProvider provider = mockProvider(registration);
		assertTrue(provider.checkCustomerUniqueness(registration.getCustomer()));
		assertNotNull(provider.registration.getCustomer());
		assertEquals("Bryan", provider.registration.getCustomer().getCustomerName().getFirstName());
		assertEquals("Maravilla", provider.registration.getCustomer().getCustomerName().getLastName());
		assertEquals("bmaravilla@gmail.com", provider.registration.getCustomer().getEmailAddress());
		assertEquals("password123", provider.registration.getCustomer().getPassword());
		assertTrue(provider.registration.getIsUnique());
	}
	
	@Test
	public void testCustomerRegistrationFullNameFailure() {
		Registration registration = mockRegistration("Dannel", "Alon", "bmaravilla@gmail.com", "password123");
		RegistrationProvider provider = mockProvider(registration);
		assertFalse(provider.checkCustomerUniqueness(registration.getCustomer()));
		assertNull(provider.registration.getCustomer());
		assertFalse(provider.registration.getIsUnique());
	}
	
	@Test
	public void testCustomerRegistrationEmailAddressFailure() {
		Registration registration = mockRegistration("Bryan", "Maravilla", "cloe@gmail.com", "password123");
		RegistrationProvider provider = mockProvider(registration);
		assertFalse(provider.checkCustomerUniqueness(registration.getCustomer()));
		assertNull(provider.registration.getCustomer());
		assertFalse(provider.registration.getIsUnique());
	}

	public Registration mockRegistration(String firstName, String lastName, String emailAddress, 
			String password) {
		Registration registration = new Registration();
		Customer customer = new Customer();
		CustomerName customerName = new CustomerName();
		customerName.setFirstName(firstName);
		customerName.setLastName(lastName);
		customer.setCustomerName(customerName);
		customer.setEmailAddress(emailAddress);
		customer.setPassword(password);
		registration.setCustomer(customer);
		registration.setCustomer(customer);
		return registration;
	}
	
	
	public RegistrationProvider mockProvider(Registration registration) {
		RegistrationProvider provider = new RegistrationProvider();
		provider.registration = registration;
		return provider;
	}
}
