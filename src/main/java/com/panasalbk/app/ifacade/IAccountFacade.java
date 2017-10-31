package com.panasalbk.app.ifacade;

import com.panasalbk.app.dto.AccountDto;
import com.panasalbk.app.dto.BankInfoDto;
import com.panasalbk.app.model.id.AccountId;

public interface IAccountFacade {
	public BankInfoDto getAccounts(String customerId);
	public AccountDto getSingleAccount(String customerId, String accountId);
	public AccountDto addAccount(AccountDto accountDto);
	public AccountDto updateAccount(AccountDto accountDto);
	public void deleteAccount(String accountId);
}
