package com.panasalbk.app.constant;

import static com.panasalbk.app.constant.EBankingCommandNumbers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.panasalbk.app.annotation.WrittenBy;
/**
 * Latest edition date: 08/02/17
 * EBankingCommand Class
 * @author AloniD
 *
 */

public final class EBankingCommands {
	//TODO implement commands for customer registration
	//TODO implement commands for deposit and withdrawal
	
	private static HashMap<String, String> commands_val = 
			new HashMap<String, String>() {{
		put("C", "Check Balance");
		put("D", "Deposit Money");
		put("P", "Pay Credit Card / Bill");
		put("R", "Request Money");
		put("V","View Account Information");
		put("W", "Withdraw Money");
		put("E", "Exit");
	}};
	
	private static final HashMap<String, String> subcommands_val = 
			new HashMap<String, String>() {{
		put("D1", "Deposit to Chequing Account");
		put("D2", "Deposit to Saving Account");
		put("P1", "Pay Credit Card");
		put("P2", "Pay Bill");
		put("V1","View Chequing Account Info");
		put("V2","View Saving Account Info");
		put("W1", "Withdraw from Chequing Account");
		put("W2", "Withdraw from Saving Account");
		put("B", "Back");
	}};
	
	
	private static final HashMap<String, Integer> commands_code = 
			new HashMap<String, Integer>(){{
		put("C", CHECK_BALANCE);
		put("D", DEPOSIT_MONEY);
		put("P", PAY_CREDIT_CARD_OR_BILL);
		put("R", REQUEST_MONEY);
		put("V", VIEW_ACCOUNT_INFORMATION);
		put("W", WITHDRAW_MONEY);
		put("E", EXIT);
	}};
	
	private static final HashMap<String, Integer> subcommands_code = 
			new HashMap<String, Integer>(){{	
		put("D1", DEPOSIT_CHEQUING_ACCOUNT);
		put("D2", DEPOSIT_SAVING_ACCOUNT);
		put("P1", PAY_CREDIT_CARD);
		put("P2", PAY_BILL);
		put("V1", VIEW_CHEQUING_ACCOUNT_INFO);
		put("V2", VIEW_SAVING_ACCOUNT_INFO);
		put("W1", WITHDRAW_FROM_CHEQUING_ACCOUNT);
		put("W2", WITHDRAW_FROM_CHEQUING_ACCOUNT);
	}};
	
	// Sorting Maps (HashMap => TreeMap => Map)
	public static Map<String, String> COMMANDS_VAL =
			new TreeMap<String, String>(commands_val);
	
	public static Map<String, String> SUBCOMMANDS_VAL =
			new TreeMap<String, String>(subcommands_val);
	
	public static Map<String, Integer> COMMANDS_CODE =
			new TreeMap<String, Integer>(commands_code);
	
	public static Map<String, Integer> SUBCOMMANDS_CODE =
			new TreeMap<String, Integer>(subcommands_code);
	
	private EBankingCommands() {
		//no body
	}
	
}
