package com.panasalbk.app.utils;

public class StringUtils {
	
	/**
	 * Remove white spaces from input value and capitalize
	 * the first letter only.
	 * @param word
	 * @return
	 */
	public static String capitalize(String word) {
		String formattedWord = word.trim().replaceAll("\\s","");
		return String.format("%s%s", formattedWord.substring(0, 1).toUpperCase(), 
				formattedWord.substring(1, formattedWord.length()).toLowerCase());
	}
	
	/**
	 * Remove white spaces from input value.
	 * @param word
	 * @return
	 */
	public static String trim(String word) {
		return word.trim().replaceAll("\\s","");
	}

}
