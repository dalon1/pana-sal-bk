package com.panasalbk.app.interfaces;

import java.util.List;

import com.panasalbk.app.models.BankAccount;
import com.panasalbk.app.models.abstracts.Card;
import com.panasalbk.app.models.ids.CustomerId;

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
