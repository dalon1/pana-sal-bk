package com.panasalbk.app.testing.xml;

import java.util.List;

import org.junit.Test;

import com.panasalbk.app.dba.CardRepository;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.model.abstract_model.Card;

import org.junit.Assert;

public class CardXMLTest {

	@Test
	public void testRetrievingDebitCardSuccess() {
		List<Card> cardList = CardRepository.getCardList();
		Assert.assertEquals(3, cardList.size());
		Card card = cardList.get(0);
		Assert.assertNotNull(card);
		Assert.assertTrue("Card is not a Debit Card", card instanceof DebitCard);
		DebitCard debitCard = (DebitCard) card;
		
		Assert.assertEquals("100", debitCard.getCustomerId().getId().toString());
		Assert.assertEquals("DEBIT", debitCard.getCardType());
		Assert.assertEquals("4567", debitCard.getPin());
		Assert.assertEquals("Dannel Alon", debitCard.getCardHolder());
	}
	
	@Test
	public void testRetrievingCreditCardSuccess(){
		List<Card> cardList = CardRepository.getCardList();
		Assert.assertEquals(3, cardList.size());
		Card card = cardList.get(1);
		Assert.assertNotNull(card);
		Assert.assertTrue("Card is not a Credit Card", card instanceof CreditCard);
		CreditCard creditCard = (CreditCard) card;
		
		Assert.assertEquals("100", creditCard.getCustomerId().getId().toString());
		Assert.assertEquals("CREDIT", creditCard.getCardType());
		Assert.assertEquals("9876", creditCard.getPin());
		Assert.assertEquals("Dannel Alon", creditCard.getCardHolder());
		
	}
}
