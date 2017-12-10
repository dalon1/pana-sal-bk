package com.panasalbk.app.model;

import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.model.id.TransactionId;

public class Transaction {
	private TransactionId id;
	private CustomerId customerId;
	private AccountId accountId;
	private Amount amount;
	private String accountNumber;
	private String accountBalance;
	private String accountType;
	private String transactionType;
	
	public TransactionId getId() {
		return id;
	}
	public void setId(TransactionId id) {
		this.id = id;
	}
	public CustomerId getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerId customerId) {
		this.customerId = customerId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public AccountId getAccountId() {
		return accountId;
	}
	public void setAccountId(AccountId accountId) {
		this.accountId = accountId;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	
}
