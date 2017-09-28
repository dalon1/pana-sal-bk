package com.panasalbk.app.validation;

import static com.panasalbk.app.constant.EBankingCommands.*;

import java.util.Map;

/**
 * Command Validation -
 * Validates if correct command exist in Commands
 * o Subcommands lists.
 * @author AloniD
 *
 */
public class CommandValidation {
	// Validates if command is valid in command list.
	public static boolean isValidCommand(String str) {
		Boolean isFound 		= false;
		
		for (Map.Entry<String, String> entry : COMMANDS_VAL.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			if (key.equals(str) && !InputValidation.isNull(val)) {
				isFound = true; break;
			}
			
		}
		
		return isFound;
	}
	
	// Validates if command key (charAt(0)) exists in sub-command list.
	public static boolean isValidSubCommand(String str) {
		Boolean isFound 		= false;
		
		for (Map.Entry<String, String> entry : SUBCOMMANDS_VAL.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			
			if (key.equals(str) && !InputValidation.isNull(val)) {
				isFound = true; break;
			}
			
		}
		
		return isFound;
	}
	
	// Validates if command key (charAt(0)) exists in sub-command list.
		public static boolean isValidKeyCommandInSubCommandList(String str) {
			Boolean isFound 		= false;
			
			for (Map.Entry<String, String> entry : SUBCOMMANDS_VAL.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				
				if (Character.toString(key.charAt(0)).equals(str) 
						&& !InputValidation.isNull(val)) {
					isFound = true; break;
				}
				
			}
			
			return isFound;
		}
	
	
}
