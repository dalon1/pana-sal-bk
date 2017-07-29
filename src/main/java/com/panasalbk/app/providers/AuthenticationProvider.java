package com.panasalbk.app.providers;

import java.util.Scanner;
import com.panasalbk.app.interfaces.IAuthenticationProvider;
import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.models.Customer;
import com.panasalbk.app.models.Authentication;

public class AuthenticationProvider implements IAuthenticationProvider {

	public Authentication authentication;
	
	public void printAuthenticPanel() {
		Scanner scan = new Scanner(System.in);
		authentication.setUsername(printScan("username", scan));
		authentication.setPassword(printScan("password", scan));
	}
	
	// ** Change method name later
	public String printScan(String prompt, Scanner scan) {
		System.out.printf("%s:",prompt);
		String in = scan.next();
		// InputValidation
		return in;
	}

	// + Authentication method
	public void authenticate() {
		do {
			printAuthenticPanel();
			retrieveCustomer();
			printAuthenticResult();
			printNotFoundCustomerMessage();
		
			// Number of trials is being subtracted in the 
			// ... do-while loop condition
		} while(!authentication.getIsAuthentic() && authentication.getNumTrials() > 0); 
		
	}

	public Customer retrieveCustomer() {
		// implement authentication
		for (Customer cust : CustomerRepository.getCustomers()) {
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
