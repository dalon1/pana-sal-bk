package com.panasalbk.app.test.provider;

import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Ignore;

import com.panasalbk.app.dba.AccountRepository;
import com.panasalbk.app.dba.CardRepository;
import com.panasalbk.app.iprovider.IProfileProvider;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.provider.AccountProvider;

import org.junit.Assert;
import org.junit.Before;

@RunWith(MockitoJUnitRunner.class)
public class AccountProviderTest {
	
	@InjectMocks
	AccountProvider accountProvider;
	
	@Mock
	CardRepository cardRepository;
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	IProfileProvider profileProvider;
	
	@Before
	public void setup() {
		Mockito.when(cardRepository.getCardList()).thenReturn(mockCards());
		Mockito.when(profileProvider.getProfile(any(CustomerId.class))).thenReturn(mockProfile());
	}
	
	@Test
	public void findAllCardsByCustomerIdSuccess() {
		List<Card> cardList = accountProvider.findCards(mockCustomer("100").getId());
		Assert.assertEquals(2, cardList.size());
		Assert.assertEquals("100", cardList.get(0).getCustomerId().getId());
		Assert.assertTrue("The card is not a credit card", cardList.get(0) instanceof CreditCard);
		Assert.assertEquals("100", cardList.get(1).getCustomerId().getId());
		Assert.assertTrue("The card is not debit card", cardList.get(1) instanceof DebitCard);
	}
	
	@Test
	public void findAllCardsByUnkownCustomerIdFailure() {
		List<Card> cardList = accountProvider.findCards(mockCustomer("999").getId());
		Assert.assertEquals(0, cardList.size());
	}
	
	
	private Customer mockCustomer(String id) {
		Customer customer = new Customer();
		customer.setId(new CustomerId(id));
		return customer;
	}
	
	private Profile mockProfile() {
		Profile profile = new Profile();
		profile.setId(new CustomerId("100"));
		CustomerName name = new CustomerName();
		name.setFirstName("Dannel");
		name.setLastName("Alon");
		profile.setCustomerName(name);
		return profile;
	}
	
	private List<Card> mockCards() {
		List<Card> cards = new ArrayList<Card>();
		CreditCard credit = new CreditCard();
		credit.setBrand("VISA");
		credit.setPin("9893");
		credit.setCustomerId(new CustomerId("100"));
		cards.add(credit);
		credit = new CreditCard();
		credit.setBrand("MASTERCARD");
		credit.setPin("5050");
		credit.setCustomerId(new CustomerId("200"));
		cards.add(credit);
		credit = new CreditCard();
		credit.setBrand("AMEX");
		credit.setPin("3003");
		credit.setCustomerId(new CustomerId("300"));
		cards.add(credit);
		DebitCard debit = new DebitCard();
		debit.setBrand("VISA");
		debit.setPin("2020");
		debit.setCustomerId(new CustomerId("100"));
		cards.add(debit);
		debit = new DebitCard();
		debit.setBrand("VISA");
		debit.setPin("2099");
		debit.setCustomerId(new CustomerId("400"));
		cards.add(debit);
		return cards;
	}
}
