package com.panasalbk.app.controllers;

import com.panasalbk.app.annotations.WrittenBy;

import com.panasalbk.app.models.Registration;
import com.panasalbk.app.providers.RegistrationProvider;
import com.panasalbk.app.facades.RegistrationFacade;

@WrittenBy(
		author="Dannel",
		date="19/03/2017",
		comment="Registration panel and registration behaviour should be implemented")
public class RegistrationController {
	public void start() {
		/*// Registration Model Class - Domain Object Fields (Data)
		Registration registration = new Registration();
		
		// Registration Provider Class - Domain Object Methods (behavior)
		RegistrationProvider provider = new RegistrationProvider();
		provider.registration = registration;
		provider.registrate();*/
		RegistrationFacade facade = new RegistrationFacade();
		facade.registrate(new Registration());
		
	}
}
