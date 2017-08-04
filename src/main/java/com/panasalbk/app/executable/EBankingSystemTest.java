package com.panasalbk.app.executable;

import com.panasalbk.app.annotations.WrittenBy;
import com.panasalbk.app.controllers.EBankingSystem;
import com.panasalbk.app.controllers.AuthenticationController;
import com.panasalbk.app.controllers.RegistrationController;

import java.util.Date;

@WrittenBy(
		author="Dannel",
		date="03/03/2017")
public class EBankingSystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AuthenticationController().start();
		//new RegistrationController().start();
	}
	
}
