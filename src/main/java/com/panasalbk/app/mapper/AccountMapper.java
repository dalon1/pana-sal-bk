package com.panasalbk.app.mapper;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.AccountDto;
import com.panasalbk.app.model.abstract_model.Mapper;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.StringUtils;
import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.Customer;

@Component
public class AccountMapper extends Mapper<AccountDto, BankAccount> {

	@Override
	public AccountDto toDto(BankAccount model) {
		// TODO Auto-generated method stub
		AccountDto dto = new AccountDto();
		if (model.getCreditCards() != null && !model.getCreditCards().isEmpty())
			dto.setCreditCards(model.getCreditCards());
		if (model.getDebitCards() != null && !model.getDebitCards().isEmpty())
			dto.setDebitCards(model.getDebitCards());
		/*if (model.getChequingAccounts() != null & !model.getChequingAccounts().isEmpty())
			dto.setChequingAccounts(model.getChequingAccounts());
		if (model.getSavingAccounts() != null && !model.getSavingAccounts().isEmpty())
			dto.setSavingAccounts(model.getSavingAccounts());*/
		return dto;
	}

	@Override
	public BankAccount toModel(AccountDto dto) {
		// TODO Auto-generated method stub
		BankAccount model = new BankAccount();
		if (StringUtils.isEmpty(dto.getCustomerId())) {
			Customer customer = new Customer();
			customer.setId(new CustomerId(dto.getCustomerId()));
			model.setCustomer(customer);
		}
		return model;
	}

}
