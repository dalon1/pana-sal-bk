package com.panasalbk.app.model.abstract_model;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.model.id.AccountId;

import java.util.Date;

@WrittenBy(
		author="Dannel",
		date="20/03/2017",
		comment="schema for all accounts")
public abstract class Account {
	/*
	 * Attributes
	 */
	protected AccountId id;
	protected String accountNumber;
	protected String accountNumberMasked;
	protected String accountType;
	protected double balance;
	protected double availableFunds;
	protected String productName;
	protected String accountNickname;
	protected String accountHolderName;
	protected Date accountCreationDate;
	
	public AccountId getId() {
		return id;
	}
	public void setId(AccountId id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumberMasked() {
		return accountNumberMasked;
	}
	public void setAccountNumberMasked(String accountNumberMasked) {
		this.accountNumberMasked = accountNumberMasked;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAvailableFunds() {
		return availableFunds;
	}
	public void setAvailableFunds(double availableFunds) {
		this.availableFunds = availableFunds;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAccountNickname() {
		return accountNickname;
	}
	public void setAccountNickname(String accountNickname) {
		this.accountNickname = accountNickname;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	
	
}
