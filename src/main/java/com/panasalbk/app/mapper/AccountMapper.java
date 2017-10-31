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
		return null;
	}

	@Override
	public BankAccount toModel(AccountDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
