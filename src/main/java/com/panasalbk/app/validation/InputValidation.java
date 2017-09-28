package com.panasalbk.app.validation;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.annotation.WrittenBy;

/**
 * Input Validation Class -
 * Responsible to validate all User input.
 * @author AloniD
 *
 */

@WrittenBy(
		author="Dannel",
		date="04/03/2017")
public class InputValidation {
	// Check if string is null.
	public static boolean isNull(String str) {
		return str == "" || str == null ||
				str.equals("") || str.equals(null) ? true : false;			
	}
		
	// Check if string is contains only letters.
	public static boolean isAlphaOnly(String str) {
		return str.matches("[a-zA-Z]+");
	}
		
	// Check string length
	public static boolean isLengthValid(String str, int max) {
		return str.length() <= max ? true : false;
	}	
}
