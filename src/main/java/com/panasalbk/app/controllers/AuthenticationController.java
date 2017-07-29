package com.panasalbk.app.controllers;

import com.panasalbk.app.providers.AuthenticationProvider;
import com.panasalbk.app.models.Authentication;

public class AuthenticationController {
	public void start() {
		Authentication authentication = new Authentication();
		AuthenticationProvider provider = new AuthenticationProvider();
		// TODO embed authentication class
		provider.authentication = authentication; 
		provider.authenticate();
		
		if (authentication.getIsAuthentic()) 
		{
			EBankingSystem sys = new EBankingSystem(authentication.getAuthenticCust());
			sys.Start();
		}
	}
}

