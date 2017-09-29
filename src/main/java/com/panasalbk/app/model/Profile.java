package com.panasalbk.app.model;

import com.panasalbk.app.model.id.CustomerId;

public class Profile {
	private CustomerId id;
	private CustomerName customerName;
	private String emailAddress;
	private String password;
	private String phone;
	private Address address;
	public CustomerId getId() {
		return id;
	}
	public void setId(CustomerId id) {
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
