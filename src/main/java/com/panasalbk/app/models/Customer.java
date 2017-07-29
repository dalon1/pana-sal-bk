package com.panasalbk.app.models;

import com.panasalbk.app.annotations.*;
import com.panasalbk.app.models.ids.CustomerId;
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
	private DebitCard debitCard;
	private CreditCard creditCard;
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
	public DebitCard getDebitCard() {
		return debitCard;
	}
	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
}
