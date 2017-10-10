package com.panasalbk.app.provider;

import java.util.Scanner;

import javax.inject.Inject;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.util.ScanUtils;
import com.panasalbk.app.iprovider.IRegistrationProvider;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.Registration;

@WrittenBy(
		author = "Dannel Alon",
		date = "30/07/2017",
		comment = "Implementing behavior for customer registration")
public class RegistrationProvider implements IRegistrationProvider {
	
	@Inject
	CustomerRepository customerRepository;
	
	public Registration registration;

	@Override
	public void printRegistrationPanel() {
		
		Customer customer = new Customer();
		CustomerName customerName = new CustomerName();
		customerName.setFirstName(ScanUtils.printScan("First Name"));
		customerName.setLastName(ScanUtils.printScan("Last Name"));
		customer.setCustomerName(customerName);
		customer.setEmailAddress(ScanUtils.printScan("Email Address"));
		customer.setPassword(ScanUtils.printScan("Password"));
		
		this.registration.setRegisteredCustomer(customer);
	}
	
	/**
	 * Check for the following uniqueness rules:
	 * 1. The customer's full name (first name + [middle name: not applicable] + last name) must be unique!
	 * 2. The customer's email address must be unique.
	 * */
	@Override
	public boolean checkCustomerUniqueness(Customer customer) {
		for (Customer existingCustomer : customerRepository.getCustomerList()) {
			if (existingCustomer.getEmailAddress().equalsIgnoreCase(customer.getEmailAddress())) {
				// Removing customer from registration.
				this.registration.setRegisteredCustomer(null);
				this.registration.setIsUnique(false);
				return false;
			}
			
			if (existingCustomer.getCustomerName().getFirstName().equalsIgnoreCase(customer.getCustomerName().getFirstName()) 
					&& existingCustomer.getCustomerName().getLastName().equalsIgnoreCase(customer.getCustomerName().getLastName())) {
				// Removing customer from registration.
				this.registration.setRegisteredCustomer(null);
				this.registration.setIsUnique(false);
				return false;
			}
		}
		this.registration.setIsUnique(true);
		return true;
	}
	
	@Override
	public void printRegistrationResult() {
		// printing results of the authentication
		final int LIMIT = 3;
						
		try {
			for (int i = 0; i < LIMIT; i++) {
				Thread.sleep(1000);
				System.out.printf("Validating...(%d)\n", i + 1);
			}
		} catch(Exception ex) {}
		
	}

	@Override
	public void printCustomerAlreadyExistMessage() {
		if (!registration.getIsUnique()) {
			String str = "\nCustomer already exists.\n";
			str += String.format("Please, register with different data.\n");
			
			System.out.println(str);
		} else {
			System.out.println("\nRegistration completed!");
		}
	}
	
}
