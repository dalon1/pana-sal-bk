package com.panasalbk.app.ifacade;

import com.panasalbk.app.dto.AccountDto;
import com.panasalbk.app.model.id.AccountId;

public interface IAccountFacade {
	public AccountDto getAccounts();
	public AccountDto getSingleAccount(AccountId accountId);
	public AccountDto addAccount(AccountDto accountDto);
	public AccountDto updateAccount(AccountDto accountDto);
	public void deleteAccount(AccountId accountId);
}
