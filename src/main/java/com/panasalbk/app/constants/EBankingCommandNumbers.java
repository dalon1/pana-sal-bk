package com.panasalbk.app.constants;

import com.panasalbk.app.annotations.WrittenBy;

@WrittenBy(
		author="Dannel Alon",
		date="30/03/2017")
public final class EBankingCommandNumbers {
	//TODO implement all the ebanking command numbers with their name
	/**
	 * Main Commands
	 */
	public final static int CHECK_BALANCE 					= 1000;
	public final static int DEPOSIT_MONEY 					= 2000;
	public final static int PAY_CREDIT_CARD_OR_BILL 		= 3000;
	public final static int REQUEST_MONEY 					= 4000;
	public final static int VIEW_ACCOUNT_INFORMATION 		= 5000;
	public final static int WITHDRAW_MONEY					= 6000;
	public final static int EXIT 							= 9999;
	
	/**
	 * Subcommands
	 */
	public final static int DEPOSIT_CHEQUING_ACCOUNT 		= 2010;
	public final static int DEPOSIT_SAVING_ACCOUNT			= 2020;
	public final static int PAY_CREDIT_CARD 				= 3010;
	public final static int PAY_BILL 						= 3020;
	public final static int VIEW_CHEQUING_ACCOUNT_INFO		= 5010;
	public final static int VIEW_SAVING_ACCOUNT_INFO 		= 5020;
	public final static int WITHDRAW_FROM_CHEQUING_ACCOUNT 	= 6010;
	public final static int WITHDRAW_FROM_SAVING_ACCOUNT 	= 6020;
	
	
}
