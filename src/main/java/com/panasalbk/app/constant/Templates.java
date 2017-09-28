package com.panasalbk.app.constant;

public class Templates {

	private final static String templateDirectory = "src/main/java/com/panasalbk/app/templates/";
	/*
	 * XML Templates Paths
	 */
	private final static String customerPath 		= templateDirectory + "tpl_customers.xml";
	private final static String cardPath 			= templateDirectory + "tpl_cards.xml";
	
	/*
	 * XML Builder Factories
	 * TODO this might not be needed
	 */
	public static String getCustomerPath() {
		return customerPath;
	}
	
	public static String getCardPath() {
		return cardPath;
	}
}
