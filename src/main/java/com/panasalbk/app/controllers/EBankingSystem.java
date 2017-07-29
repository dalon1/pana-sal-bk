package com.panasalbk.app.controllers;

import static com.panasalbk.app.constants.EBankingCommands.COMMANDS_VAL;
import static com.panasalbk.app.constants.EBankingCommands.COMMANDS_CODE;
import static com.panasalbk.app.constants.EBankingCommands.SUBCOMMANDS_VAL;
import static com.panasalbk.app.constants.EBankingCommands.SUBCOMMANDS_CODE;
import com.panasalbk.app.annotations.WrittenBy;
import com.panasalbk.app.models.Customer;
import com.panasalbk.app.validation.CommandValidation;
import com.panasalbk.app.validation.InputValidation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * Latest edition date: 08/02/17
 * EBankingSytem Class
 * @author AloniD
 *
 */
@WrittenBy(
		author="Dannel",
		date="19/03/2017")
public class EBankingSystem {
	private boolean isActive = false;
	private final Customer cust;		// Customer class can only be assigned once!
	private String inCommand = null;
	
	public EBankingSystem(Customer cust) {
		// Body not defined yet.
		this.cust = cust;
	}
	
	
	// Debit Card + Pin as parameters
	public void Start() {
		this.isActive 	= true;			// Class has been called!
		Boolean isEnd 	= false;
		isEnd = outDoWhilePanel();
		
	}
	
	public void End() {
		this.isActive = false;
	}
	
	// PrintPanel should be combined with PrintSubPanel
	private void PrintPanel(Customer cust) {
		final String KEY_EXIT 	= "E";
		String key, val			= null;
		String str 				= String.format("\nWelcome, %s %s", 
									this.cust.getCustomerName().getFirstName(), 
									this.cust.getCustomerName().getLastName());
		
		// Iterating over commands(key, value) for UI
		for (Map.Entry<String, String> entry : COMMANDS_VAL.entrySet()) {
			
			key = entry.getKey();
			val = entry.getValue();
			str += !key.equals(KEY_EXIT) ?
					String.format("\n%s - %s", key.toUpperCase(), val) : "";
		}
		str += String.format("\n%s - %s", KEY_EXIT, COMMANDS_VAL.get(KEY_EXIT));
		str += " : ";
		
		// Raise error if not value was found!
		System.out.print(str);
		//return str;
	}
	
	// PrintSubPanel should be combined with PrintPanel
	private void PrintSubPanel(String ikey) {
		ikey = ikey.toUpperCase();
		final String KEY_BACK 	= "B";
		String key, val 		= null;
		String str 				= "";
		
		for (Map.Entry<String, String> entry : SUBCOMMANDS_VAL.entrySet()) {
			key = entry.getKey();
			val = entry.getValue();
			
			str += Character.toString(key.charAt(0)).equals(ikey) ? 
					String.format("\n%s - %s", key.toUpperCase().charAt(1), val) : "";
			
		}
		
		if (!str.equals("")) {
			str += String.format("\n%s - %s", KEY_BACK, SUBCOMMANDS_VAL.get(KEY_BACK));
			str += " : ";
		}
		
		
		// Raise Error if not value was found!
		System.out.print(str);
		//return str;
	}
	
	

	// Only by checking one element of the sub-menu is enough to confirm
	// the existence of a sub-menu.
	// Reason: New class validation implemented.
	@Deprecated
	private boolean isSubPanelEnabled(String in) {
		final String KEY_NUM = "1";
		in = String.format("%s%s", in.toUpperCase(), KEY_NUM);
		return !SUBCOMMANDS_VAL.get(in).equals(null) ? true : false;
	}
	
	
	// Outer do-while loop with validation for panel.
	// if E, then break.
	private boolean outDoWhilePanel() {
		Scanner scan = new Scanner(System.in);
		String in1 		= null;
		Boolean isOver 	= false;
		
		
		do {
			Customer cust = new Customer();
			PrintPanel(cust);
			// Input should be validated
			in1 = scan.next().toUpperCase();
			
			if (isInputValid(in1) &&
					CommandValidation.isValidCommand(in1))
				isOver = !inDoWhileSubPanel(in1); //Why?
			
		} while(!isOver);
		//scan.close();
		return isOver;
	}
	
	// Inner do-while loop with validation for panel.
	// if B, then break.
	public boolean inDoWhileSubPanel(String in1) {
		Scanner scan = new Scanner(System.in);
		String in2		= null;
		Boolean isOver	= false;
		if (CommandValidation.isValidKeyCommandInSubCommandList(in1)) {
			do {
				PrintSubPanel(in1);
				in2 = scan.next().toUpperCase();
			
				if (isInputValid(in2) && CommandValidation.isValidSubCommand(in2)) {
					isOver = true;
				}

			} while(!isOver);
		}
		//scan.close();
		return isOver;
	}
	
	// Validating User Input
	private boolean isInputValid(String in) {
		return !InputValidation.isNull(in) &&
				InputValidation.isAlphaOnly(in) &&
				InputValidation.isLengthValid(in, 1);
	}
	
}
