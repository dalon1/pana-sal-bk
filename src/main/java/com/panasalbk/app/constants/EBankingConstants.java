package com.panasalbk.app.constants;

import com.panasalbk.app.annotations.WrittenBy;

@WrittenBy(
		author="Dannel", 
		date="20/03/2017",
		comment="Required constants for the ebanking system")
public final class EBankingConstants {
	/*
	 * Card Constants
	 */
	public static int CARD_TYPE_DEBIT 				= 0;
	public static int CARD_TYPE_CREDIT 				= 1;
	public static int CARD_TYPE_PREPAID 			= 2;
	
	/*
	 * Account Constants
	 */
	public static int ACCOUNT_TYPE_CHEQUING 		= 0;
	public static int ACCOUNT_TYPE_SAVING 			= 1;
	public static int ACCOUNT_TYPE_CREDIT 			= 2;
}
