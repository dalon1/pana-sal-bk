package com.panasalbk.app.model;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.DebitCards;
/**
 * Latest edition date: 06/02/17
 * Customer Class
 * @author AloniD
 * 
 */
@WrittenBy(
		author="Dannel",
		date="19/03/2017")
public class Customer {
	private CustomerId id;
	private CustomerName customerName;
	private String emailAddress;
	private String password = "banking";
	private String phone;
	private Address address;
	private BankAccount bankAccount;
	private DebitCards debitCards;
	private CreditCards creditCards;
	private boolean isSigned = false;
	
	public CustomerName getCustomerName() {
		return customerName;
	}
	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public CustomerId getId() {
		return id;
	}
	public void setId(CustomerId id) {
		this.id = id;
	}
	public boolean isSigned() {
		return isSigned;
	}
	public void setSigned(boolean isSigned) {
		this.isSigned = isSigned;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
