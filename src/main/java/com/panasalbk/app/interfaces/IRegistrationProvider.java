package com.panasalbk.app.interfaces;

import com.panasalbk.app.models.Customer;

public interface IRegistrationProvider {
	public void printRegistrationPanel();
	public boolean checkCustomerUniqueness(Customer customer);
	public void printRegistrationResult();
	public void printCustomerAlreadyExistMessage();
	
}
