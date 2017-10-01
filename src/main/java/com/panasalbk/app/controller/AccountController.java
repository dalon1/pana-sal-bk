package com.panasalbk.app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.AccountDto;

/**
 * Manage accounts & cards (debit, credit and prepaid)
 * @author AloniD
 * TODO implement body
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@RequestMapping(method = RequestMethod.GET)
	public AccountDto getAccounts() {
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AccountDto getSingleAccount() {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AccountDto addAccount(@RequestBody AccountDto accountDto) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAccount() {
		// nothing
	}
}
