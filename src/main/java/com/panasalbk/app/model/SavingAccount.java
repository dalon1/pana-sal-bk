package com.panasalbk.app.model;

import com.panasalbk.app.enumeration.AccountType;
import com.panasalbk.app.model.abstract_model.Account;

public class SavingAccount extends Account {
	public SavingAccount() {
		super();
		this.accountType = AccountType.SAVING.name();
	}
}
