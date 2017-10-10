package com.panasalbk.app.provider;

import java.util.List;
import java.util.Scanner;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.iprovider.IAuthenticationProvider;
import com.panasalbk.app.model.Authentication;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.DebitCards;
import com.panasalbk.app.util.ScanUtils;

@Component
public class AuthenticationProvider implements IAuthenticationProvider {

	@Inject
	CustomerRepository customerRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		// TODO Auto-generated method stub
		if (authentication.getAuthenticCust() != null) {
			authentication.setAuthenticCust(null);
			authentication.setIsAuthentic(false);
		}
		
		for (Customer customer : customerRepository.getCustomerList()) {
			if (customer.getEmailAddress().equalsIgnoreCase(authentication.getUsername()) &&
					customer.getPassword().equals(authentication.getPassword()))
				authentication.setAuthenticCust(customer);
				authentication.setIsAuthentic(true);
		}
		
		// Retrieve Capabilities >>
		// Retrieve Session here >>
		// Cache result here>>
		return authentication;
	}

	@Override
	public Authentication getAuthentication() {
		// TODO Auto-generated method stub
		// Retrieve cache here
		return null;
	}
	

}
