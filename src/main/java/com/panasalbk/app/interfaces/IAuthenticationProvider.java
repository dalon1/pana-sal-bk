package com.panasalbk.app.interfaces;

import com.panasalbk.app.models.Customer;

public interface IAuthenticationProvider {
	public void printAuthenticPanel();
	public Customer retrieveCustomer();
	//public Customer getCustomerAccounts();
	public void printAuthenticResult();
	public void printNotFoundCustomerMessage();
}
