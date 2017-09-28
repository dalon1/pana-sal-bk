package com.panasalbk.app.facade;

import com.panasalbk.app.provider.AuthenticationProvider;
import com.panasalbk.app.ifacade.IAuthenticationFacade;
import com.panasalbk.app.model.Authentication;
import com.panasalbk.app.object_factory.provider.ObjectFactory;

public class AuthenticationFacade implements IAuthenticationFacade {

	@Override
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
