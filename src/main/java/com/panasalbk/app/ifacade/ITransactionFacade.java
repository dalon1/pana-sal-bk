package com.panasalbk.app.ifacade;

import java.util.List;

import com.panasalbk.app.dto.TransactionDto;

public interface ITransactionFacade {
	public TransactionDto deposit(TransactionDto transactionDto);
	public TransactionDto cancelDeposit(String transactionId);
	public TransactionDto getSingleDeposit(String transactionId);
	public List<TransactionDto> getDeposits();
	public TransactionDto withdraw(TransactionDto transactionDto);
	// Probably, this method will never be implemented!!!
	public TransactionDto cancelWithdrawal(String transactionId);
	public List<TransactionDto> getWithdrawals();
	public List<TransactionDto> getTransactions();
}
