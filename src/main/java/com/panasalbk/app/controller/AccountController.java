package com.panasalbk.app.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.AccountDto;
import com.panasalbk.app.dto.BankInfoDto;
import com.panasalbk.app.ifacade.IAccountFacade;
import com.panasalbk.app.model.id.AccountId;

/**
 * Manage accounts & cards (debit, credit and prepaid)
 * @author AloniD
 * TODO implement body
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Inject
	public IAccountFacade accountFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public BankInfoDto getAccounts(@RequestParam(value = "customerId", required = true) String customerId) {
		return accountFacade.getAccounts(customerId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AccountDto getSingleAccount() {
		return accountFacade.getSingleAccount(null, null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AccountDto addAccount(@RequestBody AccountDto accountDto) {
		return accountFacade.addAccount(accountDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
		return accountFacade.updateAccount(accountDto);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAccount() {
		accountFacade.deleteAccount(null);
	}
}
