package com.panasalbk.app.model;

import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.list.DebitCards;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.Accounts;

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
