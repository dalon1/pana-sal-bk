package com.panasalbk.app.dto;

public class TransactionDto {
	String id;
	AmountDto amount;
	String accountNumber;
	String accountBalance; // Pending to be AmountDto
	String accountType;
	/***
	 * The following properties are pending to be implemented in the next iteration.
	 * fromAccountNumber - transfer
	 * fromAccountBalance - transfer
	 * toAccountNumber - transfer
	 * toAccountBalance - transfer
	 */
	/*String fromAccountNumber;
	String toAccountNumber;
	String fromAccountBalance;
	String toAccountBalance;*/
	String transactionType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AmountDto getAmount() {
		return amount;
	}
	public void setAmount(AmountDto amount) {
		this.amount = amount;
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
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
