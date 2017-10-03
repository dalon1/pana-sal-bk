package com.panasalbk.app.util;

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
	
	/**
	 * Check if string is empty or not.
	 * new String(null) // Empty
	 * new String("") 	// Empty
	 * new String(" ") 	// not Empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0 ? true : false;			
	}
	
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	/**
	 * Print title when starting application
	 * @param title
	 */
	public static void printTitle(String title) {
    	String s = "";
    	for (int i = 0; i < 5; i++) {
    		s += i % 2 == 0 ? String.format("**%s**",title.replaceAll(".", "*")) :
    			String.format("* %s *", title);
    		s += "\n";
    			
    	}
    	System.out.println(s);
    }

}
