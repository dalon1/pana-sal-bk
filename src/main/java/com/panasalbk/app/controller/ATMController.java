package com.panasalbk.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.BalanceDto;
import com.panasalbk.app.dto.DepositDto;
import com.panasalbk.app.dto.InternalTransferDto;
import com.panasalbk.app.dto.TransactionHistoryDto;
import com.panasalbk.app.dto.WithdrawalDto;

@RestController
public class ATMController {
	
	// Deposit
	// 	add deposit
	@RequestMapping(value = "/deposits", method = RequestMethod.POST)
	public DepositDto deposit() {
		return null;
	}
	// 	cancel deposit
	@RequestMapping(value = "/deposits", method = RequestMethod.DELETE)
	public void cancelDeposit() {
		
	}
	//	get deposit
	@RequestMapping(value = "/deposits/{id}", method = RequestMethod.GET)
	public DepositDto getSingleDeposit() {
		return null;
	}
	
	// get deposit history by customer
	@RequestMapping(value = "/deposits", method = RequestMethod.GET)
	public List<DepositDto> getDepositHistory() {
		return null;
	}
	
	// Withdrawal
	//	add withdrawal
	@RequestMapping(value = "/withdrawals", method = RequestMethod.POST)
	public WithdrawalDto withdraw() {
		return null;
	}
	
	// cancel withdrawal
	@RequestMapping(value = "/withdrawals", method = RequestMethod.DELETE)
	public void cancelWithdrawal() {
		
	}
	// get withdrawal
	@RequestMapping(value = "/withdrawals/{id}", method = RequestMethod.GET)
	public WithdrawalDto getSingleWithdrawal() {
		return null;
	}
	
	// get withdrawal history by customer
	@RequestMapping(value = "/withdrawals", method = RequestMethod.GET)
	public WithdrawalDto getWithdrawalHistory() {
		return null;
	}
	// Internal Money Transfers
	// add money transfer
	@RequestMapping(value = "/internalTransfers", method = RequestMethod.POST)
	public InternalTransferDto transferMoney() {
		return null;
	}
	
	// cancel money transfer
	@RequestMapping(value = "/internalTransfers", method = RequestMethod.DELETE)
	public void cancelTransfer() {
		
	}
	// get transfer
	@RequestMapping(value = "/internalTransfers/{id}", method = RequestMethod.GET)
	public InternalTransferDto getSingleTransfer() {
		return null;
	}
	
	// get withdrawal history by customer
	@RequestMapping(value = "/internalTransfers", method = RequestMethod.GET)
	public List<InternalTransferDto> getTransferHistory() {
		return null;
	}
	
	// transaction history
	@RequestMapping(value = "/transactionHistory", method = RequestMethod.GET)
	public TransactionHistoryDto getTransactionHistory() {
		return null;
	}
	
	// Chequing balance
	// get account balance
	@RequestMapping(value = "/accountBalances/{id}", method = RequestMethod.GET)
	public BalanceDto getAccountBalance() {
		return null;
	}
	// get debit balance
	@RequestMapping(value = "/debitBalances/{id}", method = RequestMethod.GET)
	public BalanceDto getDebitBalance() {
		return null;
	}
	// get credit balance
	@RequestMapping(value = "/creditBalances/{id}", method = RequestMethod.GET)
	public BalanceDto getCreditBalance() {
		return null;
	}
}
