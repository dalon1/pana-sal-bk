package com.panasalbk.app.iprovider;

import java.util.List;

import com.panasalbk.app.model.Transaction;

public interface ITransactionProvider {
	public Transaction deposit(Transaction transaction);
	public Transaction withdraw(Transaction transaction);
	public List<Transaction> getTransactions();
}
