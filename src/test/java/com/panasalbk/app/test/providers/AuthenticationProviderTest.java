package com.panasalbk.app.test.providers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.panasalbk.app.model.Authentication;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.provider.AuthenticationProvider;
import com.panasalbk.app.testing.mocks.MockCustomer;

public class AuthenticationProviderTest {
	MockCustomer mockCustomer = new MockCustomer();
	@Test
	public void authenticateRegisteredCustomer() {
		Authentication auth = mockAuthentication(
				mockCustomer.getRegisteredCustomer().getEmailAddress(),
				mockCustomer.getRegisteredCustomer().getPassword());
		AuthenticationProvider provider = mockAuthenticationProvider(auth);
		Customer customer = provider.retrieveCustomer();
		assertEquals(true, auth.getIsAuthentic());
		assertNotNull(customer);
		assertEquals("Dannel", customer.getCustomerName().getFirstName());
		assertEquals("Alon", customer.getCustomerName().getLastName());
		assertEquals("100", customer.getId().getId());
		
		assertEquals(1, customer.getDebitCards().size());
		DebitCard debitCard = customer.getDebitCards().get(0);
		assertEquals("100", debitCard.getCustomerId().getId());
		assertEquals("DEBIT", debitCard.getCardType());
		assertEquals("Dannel Alon", debitCard.getCardHolder());
		assertEquals("4567", debitCard.getPin());
		
		assertEquals(1, customer.getCreditCards().size());
		CreditCard creditCard = customer.getCreditCards().get(0);
		assertEquals("100", creditCard.getCustomerId().getId());
		assertEquals("CREDIT", creditCard.getCardType());
		assertEquals("Dannel Alon", creditCard.getCardHolder());
		assertEquals("9876", creditCard.getPin());
	}
	
	@Test
	public void authenticateNonRegisteredCustomer() {
		Authentication auth = mockAuthentication(
				mockCustomer.getNonRegisteredCustomer().getEmailAddress(),
				mockCustomer.getNonRegisteredCustomer().getPassword());
		AuthenticationProvider provider = mockAuthenticationProvider(auth);
		Customer customer = provider.retrieveCustomer();
		assertEquals(false, auth.getIsAuthentic());
		assertNull(customer);
	}
	
	public Authentication mockAuthentication(String emailAddress, String password) {
		Authentication auth = new Authentication();
		auth.setUsername(emailAddress);
		auth.setPassword(password);
		return auth;
	}
	
	public AuthenticationProvider mockAuthenticationProvider(Authentication authentication) {
		AuthenticationProvider provider = new AuthenticationProvider();
		provider.authentication = authentication;
		return provider;
	}

}
