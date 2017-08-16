package com.panasalbk.app.providers;

import java.util.Scanner;
import com.panasalbk.app.interfaces.IAuthenticationProvider;
import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.models.Customer;
import com.panasalbk.app.utils.ScanUtils;
import com.panasalbk.app.models.Authentication;

public class AuthenticationProvider implements IAuthenticationProvider {

	public Authentication authentication;
	
	public void printAuthenticPanel() {
		authentication.setUsername(ScanUtils.printScan("username"));
		authentication.setPassword(ScanUtils.printScan("password"));
	}

	public Customer retrieveCustomer() {
		// implement authentication
		for (Customer cust : CustomerRepository.getCustomerList()) {
			if (cust.getEmailAddress().equalsIgnoreCase(authentication.getUsername()) &&
					cust.getPassword().equals(authentication.getPassword())) {
				authentication.setIsAuthentic(true);
				authentication.setAuthenticCust(cust);
				break;
			}	
		}
		return null;
	}

	public void printNotFoundCustomerMessage() {
		if (!authentication.getIsAuthentic()) {
			authentication.setNumTrials(authentication.getNumTrials() - 1);
			String str = "\nCustomer not found.\n";
			str += String.format("Please, try again (%d)\n", authentication.getNumTrials());
			
			System.out.println(str);
		}
	}

	public void printAuthenticResult() {
		// printing results of the authentication
		final int LIMIT = 3;
				
		try {
			for (int i = 0; i < LIMIT; i++) {
				Thread.sleep(1000);
				System.out.printf("Validating...(%d)\n", i + 1);
			}
		} catch(Exception ex) {}
	}

}
