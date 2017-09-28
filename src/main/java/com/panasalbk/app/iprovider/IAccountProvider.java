package com.panasalbk.app.iprovider;

import java.util.List;

import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.CustomerId;

public interface IAccountProvider {
	Card addCard();
	void updateCard(Card card);
	// The Card can't longer be retrieved from the get-call
	Card cancelCard(Card card);
	List<Card> findCards(CustomerId customerId);
	Card findSingleCard(CustomerId customerId);
	
	BankAccount addBankAccount();
	void updateBankAccount(BankAccount bankAccount);
	// The Bank Account can't longer be retrieved from the get-call
	BankAccount cancelBankAccount(BankAccount bankAccount);
	List<BankAccount> findBankAccounts(CustomerId customerId);
	BankAccount findBankAccount(CustomerId customerId);
}
