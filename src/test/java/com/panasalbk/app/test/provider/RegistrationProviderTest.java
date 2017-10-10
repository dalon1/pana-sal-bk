package com.panasalbk.app.test.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.Registration;
import com.panasalbk.app.provider.RegistrationProvider;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationProviderTest {
	@InjectMocks
	RegistrationProvider registrationProvider;
	
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	public void testCustomerRegistrationSuccess() {
		Registration registration = mockRegistration("Bryan", "Maravilla", "bmaravilla@gmail.com", "password123");
		Whitebox.setInternalState(registrationProvider, "registration", registration);
		
		assertTrue(registrationProvider.checkCustomerUniqueness(registration.getRegisteredCustomer()));
		assertNotNull(registrationProvider.registration.getRegisteredCustomer());
		assertEquals("Bryan", registrationProvider.registration.getRegisteredCustomer().getCustomerName().getFirstName());
		assertEquals("Maravilla", registrationProvider.registration.getRegisteredCustomer().getCustomerName().getLastName());
		assertEquals("bmaravilla@gmail.com", registrationProvider.registration.getRegisteredCustomer().getEmailAddress());
		assertEquals("password123", registrationProvider.registration.getRegisteredCustomer().getPassword());
		assertTrue(registrationProvider.registration.getIsUnique());
	}
	
	@Test
	@Ignore
	public void testCustomerRegistrationFullNameFailure() {
		Registration registration = mockRegistration("Dannel", "Alon", "bmaravilla@gmail.com", "password123");
		Whitebox.setInternalState(registrationProvider, "registration", registration);
		
		assertFalse(registrationProvider.checkCustomerUniqueness(registration.getRegisteredCustomer()));
		assertNull(registrationProvider.registration.getRegisteredCustomer());
		assertFalse(registrationProvider.registration.getIsUnique());
	}
	
	@Test
	@Ignore
	public void testCustomerRegistrationEmailAddressFailure() {
		Registration registration = mockRegistration("Bryan", "Maravilla", "cloe@gmail.com", "password123");
		Whitebox.setInternalState(registrationProvider, "registration", registration);
		
		assertFalse(registrationProvider.checkCustomerUniqueness(registration.getRegisteredCustomer()));
		assertNull(registrationProvider.registration.getRegisteredCustomer());
		assertFalse(registrationProvider.registration.getIsUnique());
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
		registration.setRegisteredCustomer(customer);
		return registration;
	}
}
