package com.panasalbk.app.interfaces;

import java.util.Scanner;
import com.panasalbk.app.models.Customer;

public interface IRegistrationProvider {
	public void registrate();
	public void printRegistrationPanel();
	public String printScan(String prompt, Scanner scan);
	public boolean checkCustomerUniqueness(Customer customer);
	public void printRegistrationResult();
	public void printCustomerAlreadyExistMessage();
	
}
