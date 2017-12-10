package com.panasalbk.app.constant;

public class Templates {

	private final static String templateDirectory = "resources/templates/";
	/*
	 * XML Templates Paths
	 */
	private final static String customerPath 		= templateDirectory + "tpl_customers.xml";
	private final static String cardPath 			= templateDirectory + "tpl_cards.xml";
	private final static String accountPath 		= templateDirectory + "tpl_accounts_#customerId#.xml";
	private final static String transactionPath		= templateDirectory + "tpl_transactions_#customerId#.xml";
	
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
	
	public static String getAccountPath(String customerId) {
		return accountPath.replace("#customerId#", customerId);
	}
	
	public static String getTransactionPath(String customerId) {
		return transactionPath.replace("#customerId#", customerId);
	}
}
