package com.panasalbk.app.providers;

import java.util.Scanner;
import com.panasalbk.app.annotations.WrittenBy;
import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.models.Customer;
import com.panasalbk.app.models.CustomerName;
import com.panasalbk.app.models.Registration;
import com.panasalbk.app.interfaces.IRegistrationProvider;

@WrittenBy(
		author = "Dannel Alon",
		date = "30/07/2017",
		comment = "Implementing behavior for customer registration")
public class RegistrationProvider implements IRegistrationProvider {
	
	public Registration registration;

	public void printRegistrationPanel() {
		Scanner scan = new Scanner(System.in);
		
		Customer customer = new Customer();
		CustomerName customerName = new CustomerName();
		customerName.setFirstName(printScan("First Name", scan));
		customerName.setLastName(printScan("Last Name", scan));
		customer.setCustomerName(customerName);
		customer.setEmailAddress(printScan("Email Address", scan));
		customer.setPassword(printScan("Password", scan));
		
		this.registration.setRegisteredCustomer(customer);
	}
	
	/**
	 * Check for the following uniqueness rules:
	 * 1. The customer's full name (first name + [middle name: not applicable] + last name) must be unique!
	 * 2. The customer's email address must be unique.
	 * */
	public boolean checkCustomerUniqueness(Customer customer) {
		for (Customer existingCustomer : CustomerRepository.getCustomers()) {
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

	public String printScan(String prompt, Scanner scan) {
		System.out.printf("Enter %s: ",prompt);
		String in = scan.next();
		// InputValidation
		return in;
	}
	
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

	public void printCustomerAlreadyExistMessage() {
		if (!registration.getIsUnique()) {
			String str = "\nCustomer already exists.\n";
			str += String.format("Please, register with different data.\n");
			
			System.out.println(str);
		} else {
			System.out.println("\nRegistration completed!");
		}
	}

	// Registration method
	/*
	 *  NOTE: Remove method from provider.
	 *  This method would be implemented in the facade level.
	 */
	@Deprecated
	public void registrate() {
		do {
			printRegistrationPanel();
			checkCustomerUniqueness(this.registration.getRegisteredCustomer());
			printRegistrationResult();
			printCustomerAlreadyExistMessage();
		} while(!registration.getIsUnique());
	}
	
}
