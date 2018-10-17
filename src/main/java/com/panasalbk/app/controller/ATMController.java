package com.panasalbk.app.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.InternalTransferDto;
import com.panasalbk.app.dto.TransactionDto;
import com.panasalbk.app.dto.TransactionHistoryDto;
import com.panasalbk.app.ifacade.ITransactionFacade;


@RestController
public class ATMController {
	
	@Inject
	ITransactionFacade transactionFacade;
	
	// Deposit
	// 	add deposit
	@RequestMapping(value = "/deposits", method = RequestMethod.POST)
	public TransactionDto deposit(@RequestBody TransactionDto transactionDto) {
		return transactionFacade.deposit(transactionDto);
	}
	// 	cancel deposit
	@RequestMapping(value = "/deposits/{id}", method = RequestMethod.DELETE)
	public void cancelDeposit(@PathVariable(value = "id") String transactionId) {
		transactionFacade.cancelDeposit(transactionId);
	}
	//	get deposit
	@RequestMapping(value = "/deposits/{id}", method = RequestMethod.GET)
	public TransactionDto getSingleDeposit(@PathVariable(value = "id") String transactionId) {
		return transactionFacade.getSingleTransaction(transactionId);
	}
	
	// get deposit history by customer
	@RequestMapping(value = "/deposits", method = RequestMethod.GET)
	public List<TransactionDto> getDepositHistory() {
		return transactionFacade.getTransactions();
	}
	
	// Withdrawal
	//	add withdrawal
	@RequestMapping(value = "/withdrawals", method = RequestMethod.POST)
	public TransactionDto withdraw(@RequestBody TransactionDto transactionDto) {
		return transactionFacade.withdraw(transactionDto);
	}
	
	// cancel withdrawal
	@RequestMapping(value = "/withdrawals", method = RequestMethod.DELETE)
	public void cancelWithdrawal() {
		
	}
	// get withdrawal
	@RequestMapping(value = "/withdrawals/{id}", method = RequestMethod.GET)
	public TransactionDto getSingleWithdrawal(@PathVariable(value = "id") String transactionId) {
		return transactionFacade.getSingleTransaction(transactionId);
	}
	
	// get withdrawal history by customer
	@RequestMapping(value = "/withdrawals", method = RequestMethod.GET)
	public List<TransactionDto> getWithdrawalHistory() {
		return transactionFacade.getTransactions();
	}
	// Internal Money Transfers
	// add money transfer
	@RequestMapping(value = "/internalTransfers", method = RequestMethod.POST)
	public InternalTransferDto transferMoney(@RequestBody TransactionDto transactionDto) {
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
	public TransactionDto getAccountBalance() {
		return null;
	}
	// get debit balance
	@RequestMapping(value = "/debitBalances/{id}", method = RequestMethod.GET)
	public TransactionDto getDebitBalance() {
		return null;
	}
	// get credit balance
	@RequestMapping(value = "/creditBalances/{id}", method = RequestMethod.GET)
	public TransactionDto getCreditBalance() {
		return null;
	}
}
