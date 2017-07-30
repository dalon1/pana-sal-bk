package com.panasalbk.app.models;

public class Registration {
	private Customer customer;
	private boolean isUnique;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}
}
