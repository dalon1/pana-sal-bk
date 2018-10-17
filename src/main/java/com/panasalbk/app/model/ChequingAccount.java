package com.panasalbk.app.model;

import com.panasalbk.app.enumeration.AccountType;
import com.panasalbk.app.model.abstract_model.Account;

public class ChequingAccount extends Account {
	// Account type is set in he instantiation of the object;
	public ChequingAccount() {
		super();
		this.accountType = AccountType.CHEQUING.name();
	}
}
