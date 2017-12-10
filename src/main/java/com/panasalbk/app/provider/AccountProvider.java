package com.panasalbk.app.provider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dba.AccountRepository;
import com.panasalbk.app.dba.CardRepository;
import com.panasalbk.app.iprovider.IAccountProvider;
import com.panasalbk.app.iprovider.IProfileProvider;
import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;

@Component
public class AccountProvider implements IAccountProvider{
	
	@Inject
	CardRepository cardRepository;
	
	@Inject
	AccountRepository accountRepository;
	
	@Inject
	IProfileProvider profileProvider;
	
	@Override
	public Card addCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card cancelCard(Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> findCards(CustomerId customerId) {
		List<Card> cardList = cardRepository.getCardList();
		List<Card> customerCardList = new ArrayList<Card>();
		String customerName = profileProvider.getProfile(customerId).getCustomerName().getFullName();
		for (Card card : cardList) {
			if (card.getCustomerId().getId().equals(customerId.getId()))  {
				card.setCardHolder(customerName);
				customerCardList.add(card);
			}	
		}
		return customerCardList;
	}

	@Override
	public Card findSingleCard(CustomerId customerId) {
		for (Card card : findCards(customerId)) {
			return card;
		}
		return null;
	}

	@Override
	public Account addBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBankAccount(Account bankAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account cancelBankAccount(Account bankAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findBankAccounts(CustomerId customerId) {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.getAccountList(customerId);
		String customerName = profileProvider.getProfile(customerId).getCustomerName().getFullName();
		for(Account account : accounts)
			account.setAccountHolderName(customerName);
		return accounts;
		
	}

	@Override
	public Account findBankAccount(CustomerId customerId, String accountNumber) {
		List<Account> accounts = this.findBankAccounts(customerId);
		for (Account account : accounts) {
			if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				return account;
			}
		}
		return null;
	}

	@Override
	public Account findBankAccount(CustomerId customerId, AccountId accountId) {
		if (accountId == null) return null;
		List<Account> accounts = this.findBankAccounts(customerId);
		for (Account account : accounts) {
			if (account.getId().getId().equals(accountId.getId())) {
				return account;
			}
		}
		return null;
	}

	

}
