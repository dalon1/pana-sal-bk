package com.panasalbk.app.controllers;

import com.panasalbk.app.providers.AuthenticationProvider;
import com.panasalbk.app.facades.AuthenticationFacade;
import com.panasalbk.app.models.Authentication;

public class AuthenticationController {
	public void start() {
		/*// Authentication Model Class - Domain Object Fields (Data)
		Authentication authentication = new Authentication();
		
		// Authentication Provider Class - Domain Object Methods (behavior)
		AuthenticationProvider provider = new AuthenticationProvider();
		// TODO embed authentication class
		provider.authentication = authentication; 
		provider.authenticate();*/
		Authentication authentication = new Authentication();
		AuthenticationFacade facade = new AuthenticationFacade();
		facade.authenticate(authentication);
		
		if (authentication.getIsAuthentic()) 
		{
			EBankingSystem sys = new EBankingSystem(authentication.getAuthenticCust());
			sys.Start();
		}
	}
}

