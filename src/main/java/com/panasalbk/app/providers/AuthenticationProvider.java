package com.panasalbk.app.providers;

import java.util.List;
import java.util.Scanner;
import com.panasalbk.app.interfaces.IAuthenticationProvider;
import com.panasalbk.app.dba.CustomerRepository;
import com.panasalbk.app.models.Customer;
import com.panasalbk.app.models.DebitCard;
import com.panasalbk.app.models.abstracts.Card;
import com.panasalbk.app.models.lists.CreditCards;
import com.panasalbk.app.models.lists.DebitCards;
import com.panasalbk.app.utils.ScanUtils;
import com.panasalbk.app.models.Authentication;
import com.panasalbk.app.models.CreditCard;

public class AuthenticationProvider implements IAuthenticationProvider {

	public Authentication authentication;
	
	@Override
	public void printAuthenticPanel() {
		authentication.setUsername(ScanUtils.printScan("username"));
		authentication.setPassword(ScanUtils.printScan("password"));
	}

	@Override
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
		// TODO confirm if this has to be moved to a different Class or method
		// Retrieving all customer's cards (debit & credit)
		// Don't continue if customer is not found;
		if (authentication.getAuthenticCust() == null) return null;
		AccountProvider provider = new AccountProvider();
		List<Card> cardList =provider.findCards(authentication.getAuthenticCust().getId());
		CreditCards creditCardList = new CreditCards();
		DebitCards debitCardList = new DebitCards();
		for (Card card : cardList) {
			if (card instanceof DebitCard)
				debitCardList.add((DebitCard) card);
			if (card instanceof CreditCard)
				creditCardList.add((CreditCard) card);
		}
		authentication.getAuthenticCust().setCreditCards(creditCardList);
		authentication.getAuthenticCust().setDebitCards(debitCardList);
		return authentication.getAuthenticCust();
	}

	@Override
	public void printNotFoundCustomerMessage() {
		if (!authentication.getIsAuthentic()) {
			authentication.setNumTrials(authentication.getNumTrials() - 1);
			String str = "\nCustomer not found.\n";
			str += String.format("Please, try again (%d)\n", authentication.getNumTrials());
			
			System.out.println(str);
		}
	}

	@Override
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
