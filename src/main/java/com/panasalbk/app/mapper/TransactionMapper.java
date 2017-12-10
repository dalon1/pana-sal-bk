package com.panasalbk.app.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.AmountDto;
import com.panasalbk.app.dto.TransactionDto;
import com.panasalbk.app.model.Amount;
import com.panasalbk.app.model.Transaction;
import com.panasalbk.app.model.abstract_model.Mapper;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.StringUtils;

@Component
public class TransactionMapper extends Mapper<TransactionDto, Transaction>{

	@Override
	public TransactionDto toDto(Transaction model) {
		TransactionDto dto = new TransactionDto();
		if (model.getId() != null) {
			dto.setId(model.getId().getId());
		}
		
		if (model.getAmount() != null) {
			AmountDto amount = new AmountDto();
			amount.setAmount(model.getAmount().getAmount());
			amount.setCurrency(model.getAmount().getCurrency());
			dto.setAmount(amount);
		}
		if (!StringUtils.isEmpty(model.getTransactionType())) {
			 dto.setTransactionType(model.getTransactionType());
		}
		if (!StringUtils.isEmpty(model.getAccountBalance())) {
			dto.setAccountBalance(model.getAccountBalance());
		}
		if (!StringUtils.isEmpty(model.getAccountNumber())) {
			dto.setAccountNumber(model.getAccountNumber());
		}
		
		if (!StringUtils.isEmpty(model.getAccountType())) {
			dto.setAccountType(model.getAccountType());
		}
		return dto;
	}

	@Override
	public Transaction toModel(TransactionDto dto) {
		Transaction model = new Transaction();
		
		if (dto.getAmount() != null) {
			Amount amount = new Amount();
			amount.setAmount(dto.getAmount().getAmount());
			// PENDING set the currency : not yet
			model.setAmount(amount);
		}
		
		if (!StringUtils.isEmpty(dto.getAccountNumber())) {
			model.setAccountNumber(dto.getAccountNumber());
		}
		// TODO CHANGE THIS!!!!!!!!!!! JUST FOR TESTING PURPOSES
		model.setCustomerId(new CustomerId("100"));
		
		return model;
	}
	
	public List<TransactionDto> toDtoList(List<Transaction> models) {
		List<TransactionDto> dtos = new ArrayList<TransactionDto>();
		for (Transaction model : models) {
			dtos.add(this.toDto(model));
		}
		return dtos;
	}

}
