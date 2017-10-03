package com.panasalbk.app.facade;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.AccountDto;
import com.panasalbk.app.ifacade.IAccountFacade;
import com.panasalbk.app.iprovider.IAccountProvider;
import com.panasalbk.app.mapper.AccountMapper;
import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.DebitCards;

@Component
public class AccountFacade implements IAccountFacade {

	@Inject
	IAccountProvider accountProvider;
	
	@Inject
	AccountMapper accountMapper;
	
	@Override
	public AccountDto getAccounts(String customerId) {
		BankAccount bankAccount = new BankAccount();
		
		List<Card> cards = accountProvider.findCards(new CustomerId(customerId));
		
		for (Card card : cards) {
			if (card instanceof DebitCard)  {
				if (bankAccount.getDebitCards() == null)
					bankAccount.setDebitCards(new DebitCards());
				
				bankAccount.getDebitCards().add((DebitCard) card);
			}
			
			if (card instanceof CreditCard) {
				if (bankAccount.getCreditCards() == null)
					bankAccount.setCreditCards(new CreditCards());
				
				bankAccount.getCreditCards().add((CreditCard) card);
			}
		}
		
		return accountMapper.toDto(bankAccount);
	}

	@Override
	public AccountDto getSingleAccount(String customerId, String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDto addAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		
	}

}
