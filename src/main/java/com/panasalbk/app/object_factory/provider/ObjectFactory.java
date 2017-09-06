package com.panasalbk.app.object_factory.provider;

import com.panasalbk.app.providers.AccountProvider;
import com.panasalbk.app.providers.AuthenticationProvider;
import com.panasalbk.app.providers.RegistrationProvider;

public class ObjectFactory {
	
	public static AuthenticationProvider createAuthenticationProvider() {
		return new AuthenticationProvider();
	}
	
	public static RegistrationProvider createRegistrationProvider() {
		return new RegistrationProvider();
	}
	
	public static AccountProvider createAccountProvider() {
		return new AccountProvider();
	}
}
