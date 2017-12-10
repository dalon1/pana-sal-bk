package com.panasalbk.app.testing.xml;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.panasalbk.app.dba.CardRepository;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.model.abstract_model.Card;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CardXMLTest {

	@InjectMocks
	CardRepository cardRepository;
	
	@Test
	public void testRetrievingDebitCardSuccess() {
		List<Card> cardList = cardRepository.getCardList();
		Assert.assertEquals(3, cardList.size());
		Card card = cardList.get(0);
		Assert.assertNotNull(card);
		Assert.assertTrue("Card is not a Debit Card", card instanceof DebitCard);
		DebitCard debitCard = (DebitCard) card;
		
		Assert.assertEquals("100", debitCard.getCustomerId().getId().toString());
		Assert.assertEquals("DEBIT", debitCard.getCardType());
		Assert.assertEquals("4567", debitCard.getPin());
		//Assert.assertEquals("Dannel Alon", debitCard.getCardHolder()); >> not applicable
	}
	
	@Test
	public void testRetrievingCreditCardSuccess(){
		List<Card> cardList = cardRepository.getCardList();
		Assert.assertEquals(3, cardList.size());
		Card card = cardList.get(1);
		Assert.assertNotNull(card);
		Assert.assertTrue("Card is not a Credit Card", card instanceof CreditCard);
		CreditCard creditCard = (CreditCard) card;
		
		Assert.assertEquals("100", creditCard.getCustomerId().getId().toString());
		Assert.assertEquals("CREDIT", creditCard.getCardType());
		Assert.assertEquals("9876", creditCard.getPin());
		//Assert.assertEquals("Dannel Alon", creditCard.getCardHolder()); >> not applicable
		
	}
}
