package com.panasalbk.app.provider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dba.CardRepository;
import com.panasalbk.app.iprovider.IAccountProvider;
import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.CustomerId;

@Component
public class AccountProvider implements IAccountProvider{
	
	@Override
	public Card addCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card cancelCard(Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> findCards(CustomerId customerId) {
		List<Card> cardList = CardRepository.getCardList();
		List<Card> customerCardList = new ArrayList<Card>();
		for (Card card : cardList) {
			if (card.getCustomerId().getId().equals(customerId.getId()))  {
				customerCardList.add(card);
			}	
		}
		return customerCardList;
	}

	@Override
	public Card findSingleCard(CustomerId customerId) {
		for (Card card : findCards(customerId)) {
			return card;
		}
		return null;
	}

	@Override
	public BankAccount addBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankAccount cancelBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> findBankAccounts(CustomerId customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount findBankAccount(CustomerId customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
