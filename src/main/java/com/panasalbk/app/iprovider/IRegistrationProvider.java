package com.panasalbk.app.iprovider;

import com.panasalbk.app.model.Customer;

public interface IRegistrationProvider {
	public void printRegistrationPanel();
	public boolean checkCustomerUniqueness(Customer customer);
	public void printRegistrationResult();
	public void printCustomerAlreadyExistMessage();
	
}
