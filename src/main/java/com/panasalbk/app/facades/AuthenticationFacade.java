package com.panasalbk.app.facades;

import com.panasalbk.app.providers.AuthenticationProvider;
import com.panasalbk.app.interfaces.IAuthenticationFacade;
import com.panasalbk.app.models.Authentication;
import com.panasalbk.app.object_factory.provider.ObjectFactory;

public class AuthenticationFacade implements IAuthenticationFacade {

	public void authenticate(Authentication authentication) {
		AuthenticationProvider provider = ObjectFactory.createAuthenticationProvider();
		provider.authentication = authentication;
		do {
			provider.printAuthenticPanel();
			provider.retrieveCustomer();
			provider.printAuthenticResult();
			provider.printNotFoundCustomerMessage();
		} while(!provider.authentication.getIsAuthentic() 
				&& provider.authentication.getNumTrials() > 0);
	}
}
