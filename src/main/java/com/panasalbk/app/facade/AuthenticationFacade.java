package com.panasalbk.app.facade;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.ifacade.IAuthenticationFacade;
import com.panasalbk.app.iprovider.IAuthenticationProvider;
import com.panasalbk.app.model.Authentication;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
	
	@Inject
	IAuthenticationProvider authenticationProvider;

	@Override
	public void authenticate(Authentication authentication) {
		
		/*authenticationProvider.authentication = authentication;
		do {
			authenticationProvider.printAuthenticPanel();
			authenticationProvider.retrieveCustomer();
			authenticationProvider.printAuthenticResult();
			authenticationProvider.printNotFoundCustomerMessage();
		} while(!authenticationProvider.authentication.getIsAuthentic() 
				&& authenticationProvider.authentication.getNumTrials() > 0);*/
	}
}
