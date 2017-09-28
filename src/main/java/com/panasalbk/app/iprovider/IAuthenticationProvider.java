package com.panasalbk.app.iprovider;

import com.panasalbk.app.model.Customer;

public interface IAuthenticationProvider {
	public void printAuthenticPanel();
	public Customer retrieveCustomer();
	//public Customer getCustomerAccounts();
	public void printAuthenticResult();
	public void printNotFoundCustomerMessage();
}
