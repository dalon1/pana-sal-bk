package com.panasalbk.app.dto;

import com.panasalbk.app.model.Address;
import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.DebitCards;

public class ProfileDto {
	private String id;
	private CustomerName customerName;
	private String emailAddress;
	private String password;
	private String phone;
	private Address address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CustomerName getCustomerName() {
		return customerName;
	}
	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
