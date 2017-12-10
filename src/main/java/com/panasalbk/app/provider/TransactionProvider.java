package com.panasalbk.app.provider;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dba.TransactionRepository;
import com.panasalbk.app.enumeration.TransactionType;
import com.panasalbk.app.iprovider.ITransactionProvider;
import com.panasalbk.app.model.Transaction;
import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.id.TransactionId;

@Component
public class TransactionProvider implements ITransactionProvider {

	@Inject
	TransactionRepository transactionRepository;
	
	@Inject
	AccountProvider accountProvider;
	
	@Override
	public Transaction deposit(Transaction transaction) {
		// Setting ID
		transaction.setId(new TransactionId("TXN" + Integer.toString(new Random().nextInt((999_999 - 100_000) + 1) + 100_000)));
		Account account = accountProvider.findBankAccount(transaction.getCustomerId(), transaction.getAccountNumber());
		if (account != null) {
			transaction.setAccountId(account.getId());
			transaction.setAccountBalance(Double.toString(account.getBalance()));
			transaction.setAccountType(account.getAccountType());
		}
		transaction.setTransactionType(TransactionType.DEPOSIT.name());
		transactionRepository.addTransaction(transaction);
		return transaction;
	}

	@Override
	public Transaction withdraw(Transaction transaction) {
		// TODO Auto-generated method stub
		transaction.setId(new TransactionId("TXN" + Integer.toString(new Random().nextInt((999_999 - 100_000) + 1) + 100_000)));
		Account account = accountProvider.findBankAccount(transaction.getCustomerId(), transaction.getAccountNumber());
		if (account != null) {
			transaction.setAccountId(account.getId());
			transaction.setAccountBalance(Double.toString(account.getBalance()));
			transaction.setAccountType(account.getAccountType());
		}
		transaction.setTransactionType(TransactionType.WITHDRAWAL.name());
		transactionRepository.addTransaction(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		List<Transaction> transactions = transactionRepository.getTransactions();
		for (Transaction transaction : transactions) {
			Account account = accountProvider.findBankAccount(transaction.getCustomerId(), transaction.getAccountId());
			if (account == null) continue;
			transaction.setAccountBalance(Double.toString(account.getBalance()));
			transaction.setAccountNumber(account.getAccountNumber());
			transaction.setAccountType(account.getAccountType());
		}
		return transactions;
	}

}
