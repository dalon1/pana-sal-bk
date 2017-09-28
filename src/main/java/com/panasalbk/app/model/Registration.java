package com.panasalbk.app.model;

public class Registration {
	private Customer registeredCustomer;
	private boolean isUnique;
	// Required fields for registration >>;
	private String firstName;
	private String lastName;
	private String password;
	private String emailAddress;

	public Customer getRegisteredCustomer() {
		return registeredCustomer;
	}

	public void setRegisteredCustomer(Customer registeredCustomer) {
		this.registeredCustomer = registeredCustomer;
	}

	public boolean getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}
}
