package com.panasalbk.app.controller;

import static com.panasalbk.app.constant.EBankingCommandNumbers.*;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.provider.*;

@WrittenBy(
		author="Dannel Alon",
		date="30/03/2017",
		comment="Main controller that handle all input commands")
public class EBankingController {
	private int inputCommand;

	public int getInputCommand() {
		return inputCommand;
	}

	public void setInputCommand(int inputCommand) {
		this.inputCommand = inputCommand;
	}
	
	public EBankingController(int inCommand) {
		this.inputCommand = inCommand;
	}
	/**
	 * The biggest switch will be implemented inside the start method.
	 * A better approach should be developed.
	 */
	public void start() {
		switch(this.getInputCommand()) {
		
		// -- 1000: start --
		case CHECK_BALANCE:
			CheckBalanceProvider checkBalancePro = new CheckBalanceProvider();
			break;
		// -- 1000: end --
			
		// -- 2000: start --
		case DEPOSIT_MONEY:
			DepositMoneyProvider depositMoneyPro = new DepositMoneyProvider();
			break;	
		case DEPOSIT_CHEQUING_ACCOUNT:
			DepositMoneyProvider depositChequingPro = new DepositMoneyProvider();
			break;
		case DEPOSIT_SAVING_ACCOUNT:
			DepositMoneyProvider depositSavingPro = new DepositMoneyProvider();
			break;
		// -- 2000: end --
			
		// -- 3000: start --
		case PAY_CREDIT_CARD_OR_BILL:
			PayProvider payPro = new PayProvider();
			break;
		case PAY_CREDIT_CARD:
			PayProvider payCreditCardPro = new PayProvider();
			break;
		case PAY_BILL:
			PayProvider payBillPro = new PayProvider();
			break;
		// -- 3000: end --
			
		// -- 4000: start --
		case REQUEST_MONEY:
			RequestMoneyProvider requestMoneyPro = new RequestMoneyProvider();
			break;
		// -- 4000: end --
			
		// -- 5000: start --
		case VIEW_ACCOUNT_INFORMATION:
			ViewAccountInfoProvider viewAccountPro = new ViewAccountInfoProvider();
			break;
		case VIEW_CHEQUING_ACCOUNT_INFO:
			ViewAccountInfoProvider viewChequingAccountPro = new ViewAccountInfoProvider();
			break;
		case VIEW_SAVING_ACCOUNT_INFO:
			ViewAccountInfoProvider viewSavingAccountPro = new ViewAccountInfoProvider();
			break;
		// -- 5000: end --
			
		// -- 6000: start --
		case WITHDRAW_MONEY:
			WithdrawMoneyProvider withdrawMoneyPro = new WithdrawMoneyProvider();
			break;
		case WITHDRAW_FROM_CHEQUING_ACCOUNT:
			WithdrawMoneyProvider withdrawChequingPro = new WithdrawMoneyProvider();
			break;
		case WITHDRAW_FROM_SAVING_ACCOUNT:
			WithdrawMoneyProvider withdrawSavingPro3 = new WithdrawMoneyProvider();
			break;
		// -- 6000: end --
			
		default:
			break;
		}
	}
}
