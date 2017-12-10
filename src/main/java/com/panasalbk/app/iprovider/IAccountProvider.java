package com.panasalbk.app.iprovider;

import java.util.List;

import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;

public interface IAccountProvider {
	Card addCard();
	void updateCard(Card card);
	// The Card can't longer be retrieved from the get-call
	Card cancelCard(Card card);
	List<Card> findCards(CustomerId customerId);
	Card findSingleCard(CustomerId customerId);
	
	Account addBankAccount();
	void updateBankAccount(Account bankAccount);
	// The Bank Account can't longer be retrieved from the get-call
	Account cancelBankAccount(Account bankAccount);
	List<Account> findBankAccounts(CustomerId customerId);
	// THIS NEED TO BE REFACTORED >>> !!!!
	Account findBankAccount(CustomerId customerId, String accountNumber);
	Account findBankAccount(CustomerId customerId, AccountId accountId);
}
