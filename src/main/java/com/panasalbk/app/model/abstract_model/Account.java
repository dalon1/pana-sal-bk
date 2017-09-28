package com.panasalbk.app.model.abstract_model;

import com.panasalbk.app.annotation.WrittenBy;
import java.util.Date;

@WrittenBy(
		author="Dannel",
		date="20/03/2017",
		comment="schema for all accounts")
public abstract class Account {
	/*
	 * Attributes
	 */
	protected long accountNumber;
	protected String accountNumberMasked;
	protected int accountType;
	protected double balance;
	protected double availableFunds;
	protected String productName;
	protected String accountNickname;
	protected String accountHolderName;
	protected Date accountCreationDate;
	
	/*
	 * Properties
	 */
	
	/*
	 * Instance Methods
	 */
}
