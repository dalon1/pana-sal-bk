package com.panasalbk.app.models;

import com.panasalbk.app.models.ids.AccountId;
import com.panasalbk.app.models.lists.DebitCards;
import com.panasalbk.app.models.lists.CreditCards;
import com.panasalbk.app.models.lists.Accounts;

public class BankAccount {
	private AccountId accountId;
	private Customer customer;
	private DebitCards debitCards;
	private CreditCards creditCards;
	private Accounts accounts;
	public AccountId getAccountId() {
		return accountId;
	}
	public void setAccountId(AccountId accountId) {
		this.accountId = accountId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DebitCards getDebitCards() {
		return debitCards;
	}
	public void setDebitCards(DebitCards debitCards) {
		this.debitCards = debitCards;
	}
	public CreditCards getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(CreditCards creditCards) {
		this.creditCards = creditCards;
	}
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	
	
}
