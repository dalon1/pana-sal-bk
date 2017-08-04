package com.panasalbk.app.facades;

import com.panasalbk.app.interfaces.IRegistrationFacade;
import com.panasalbk.app.models.Registration;
import com.panasalbk.app.providers.RegistrationProvider;

public class RegistrationFacade implements IRegistrationFacade {
	/**
	 * Note: The facade level would implement the full behavior of the provider 
	 *  + its interaction with the domain object class (model).
	 *  This method would be called in the controller level.
	 */
	public void registrate(Registration registration) {
		RegistrationProvider provider = new RegistrationProvider();
		provider.registration = registration;
		do {
			provider.printRegistrationPanel();
			provider.checkCustomerUniqueness(provider.registration.getRegisteredCustomer());
			provider.printRegistrationResult();
			provider.printCustomerAlreadyExistMessage();
		} while(!registration.getIsUnique());
	}	

}
