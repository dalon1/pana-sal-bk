package com.panasalbk.app.test.providers;

import java.util.List;

import org.junit.Test;
import org.junit.Ignore;

import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.object_factory.provider.ObjectFactory;

import org.junit.Assert;

public class AccountProviderTest {

	@Test
	public void findAllCardsByCustomerIdSuccess() {
		List<Card> cardList = ObjectFactory.createAccountProvider().findCards(mockCustomer("100").getId());
		Assert.assertEquals(2, cardList.size());
		Assert.assertEquals("100", cardList.get(0).getCustomerId().getId());
		Assert.assertEquals("100", cardList.get(1).getCustomerId().getId());
	}
	
	@Test
	public void findAllCardsByUnkownCustomerIdFailure() {
		List<Card> cardList = ObjectFactory.createAccountProvider().findCards(mockCustomer("999").getId());
		Assert.assertEquals(0, cardList.size());
	}
	
	@Test
	@Ignore
	public void findAllCardsByNukkCustomerIdFailure() {
		List<Card> cardList = ObjectFactory.createAccountProvider().findCards(null);
		Assert.assertEquals(0, cardList.size());
	}
	
	private Customer mockCustomer(String id) {
		Customer customer = new Customer();
		customer.setId(new CustomerId(id));
		return customer;
	}
}
