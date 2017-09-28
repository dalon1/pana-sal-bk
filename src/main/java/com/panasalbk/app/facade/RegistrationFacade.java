package com.panasalbk.app.facade;

import com.panasalbk.app.ifacade.IRegistrationFacade;
import com.panasalbk.app.model.Registration;
import com.panasalbk.app.object_factory.provider.ObjectFactory;
import com.panasalbk.app.provider.RegistrationProvider;

public class RegistrationFacade implements IRegistrationFacade {
	/**
	 * Note: The facade level would implement the full behavior of the provider 
	 *  + its interaction with the domain object class (model).
	 *  This method would be called in the controller level.
	 */
	@Override
	public void registrate(Registration registration) {
		RegistrationProvider provider = ObjectFactory.createRegistrationProvider();
		provider.registration = registration;
		do {
			provider.printRegistrationPanel();
			provider.checkCustomerUniqueness(provider.registration.getRegisteredCustomer());
			provider.printRegistrationResult();
			provider.printCustomerAlreadyExistMessage();
		} while(!registration.getIsUnique());
	}	

}
