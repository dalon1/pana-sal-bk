package com.panasalbk.app.facade;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.TransactionDto;
import com.panasalbk.app.ifacade.ITransactionFacade;
import com.panasalbk.app.iprovider.ITransactionProvider;
import com.panasalbk.app.mapper.TransactionMapper;
import com.panasalbk.app.model.Transaction;

@Component
public class TransactionFacade implements ITransactionFacade {
	
	@Inject 
	ITransactionProvider transactionProvider;

	@Inject
	TransactionMapper transactionMapper;
	
	@Override
	public TransactionDto deposit(TransactionDto transactionDto) {
		Transaction transaction = transactionMapper.toModel(transactionDto);
		return transactionMapper.toDto(transactionProvider.deposit(transaction));
	}

	@Override
	@Deprecated
	public TransactionDto cancelDeposit(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<TransactionDto> getDeposits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDto getSingleDeposit(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDto withdraw(TransactionDto transactionDto) {
		Transaction transaction = transactionMapper.toModel(transactionDto);
		return transactionMapper.toDto(transactionProvider.withdraw(transaction));
	}

	@Override
	@Deprecated
	public TransactionDto cancelWithdrawal(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDto> getWithdrawals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDto> getTransactions() {
		// TODO Auto-generated method stub
		return transactionMapper.toDtoList(transactionProvider.getTransactions());
	}

	@Override
	public TransactionDto getSingleWithdrawal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionDto getSingleTransaction(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
