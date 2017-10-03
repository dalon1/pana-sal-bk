package com.panasalbk.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.panasalbk.app.model.list.Accounts;
import com.panasalbk.app.model.list.ChequingAccounts;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.DebitCards;
import com.panasalbk.app.model.list.SavingAccounts;

@JsonInclude(Include.NON_NULL)
public class AccountDto {
	private String customerId;
	private ChequingAccounts chequingAccounts;
	private SavingAccounts savingAccounts;
	private DebitCards debitCards;
	private CreditCards creditCards;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public DebitCards getDebitCards() {
		return debitCards;
	}
	public void setDebitCards(DebitCards debitCards) {
		this.debitCards = debitCards;
	}
	public CreditCards getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(CreditCards creditCards) {
		this.creditCards = creditCards;
	}
	public ChequingAccounts getChequingAccounts() {
		return chequingAccounts;
	}
	public void setChequingAccounts(ChequingAccounts chequingAccounts) {
		this.chequingAccounts = chequingAccounts;
	}
	public SavingAccounts getSavingAccounts() {
		return savingAccounts;
	}
	public void setSavingAccounts(SavingAccounts savingAccounts) {
		this.savingAccounts = savingAccounts;
	}
}
