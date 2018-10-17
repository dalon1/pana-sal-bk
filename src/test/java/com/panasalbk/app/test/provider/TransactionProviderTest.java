package com.panasalbk.app.test.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.panasalbk.app.dba.TransactionRepository;
import com.panasalbk.app.iprovider.IAccountProvider;
import com.panasalbk.app.model.Amount;
import com.panasalbk.app.model.ChequingAccount;
import com.panasalbk.app.model.Transaction;
import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.provider.AccountProvider;
import com.panasalbk.app.provider.TransactionProvider;
import com.panasalbk.app.util.IDUtils;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TransactionProviderTest {

	@InjectMocks
	TransactionProvider transactionProvider;
	
	@Mock
	AccountProvider accountProvider;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@Before
	public void setup() {
		/**
		 * TODO investigate
		 * Why can't I a mock the response of a static method?
		 * Mockito exception: WrongTypeOfReturnValue
		 */
		//when(IDUtils.createTransactionId()).thenReturn("TXN1000");
		when(accountProvider.findBankAccount(any(CustomerId.class), any(String.class))).thenReturn(mockAccount());
	}
	
	@Test
	public void depositSuccess() {
		Assert.assertTrue("testing : temporal", true);
		Transaction transaction = transactionProvider.deposit(mockTransaction());
		assertNotNull("transaction id not present", transaction.getId());
		assertEquals(9, transaction.getId().getId().length());
		assertNotNull("customer id not present", transaction.getCustomerId());
		assertEquals("100", transaction.getCustomerId().getId());
		assertNotNull("amount not present", transaction.getAmount());
		assertEquals(100, transaction.getAmount().getAmount(), 2);
		// TODO implement enum for currency and replace in all applicable classes.
		assertEquals("CAD", transaction.getAmount().getCurrency());
		assertNotNull("account id not present", transaction.getAccountId());
		assertEquals("ACCID1000", transaction.getAccountId().getId());
		assertEquals("ACCNUM1000", transaction.getAccountNumber());
		assertEquals("CHEQUING", transaction.getAccountType());
		assertEquals("100.0", transaction.getAccountBalance());
	}

	@Test
	public void depositFailure() {
		Assert.assertTrue("testing : temporal", true);
	}
	
	@Test
	public void depositToInvalidAccountFailure() {
		Assert.assertTrue("testing : temporal", true);
	}
	
	@Test
	public void depositToNullAccountFailure() {
		Assert.assertTrue("testing : temporal", true);
	}
	
	private Account mockAccount() {
		Account account = new ChequingAccount();
		account.setAccountNumber("ACCNUM1000");
		account.setId(new AccountId("ACCID1000"));
		account.setBalance(100);
		return account;
	}
	
	
	private Transaction mockTransaction() {
		Transaction transaction = new Transaction();
		Amount amount = new Amount();
		amount.setAmount(100);
		transaction.setAmount(amount);
		transaction.setCustomerId(new CustomerId("100"));
		// VALUE COMING FROM DTO -- 
		transaction.setAccountNumber("ACCNUM1000");
		return transaction;
	}
}
