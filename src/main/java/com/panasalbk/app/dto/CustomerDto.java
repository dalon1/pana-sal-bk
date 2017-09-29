package com.panasalbk.app.dto;

import com.panasalbk.app.model.Address;
import com.panasalbk.app.model.BankAccount;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.model.list.CreditCards;
import com.panasalbk.app.model.list.DebitCards;

public class CustomerDto {
	private CustomerId id;
	private CustomerName customerName;
	private String emailAddress;
	private String password;
	private String phone;
	private Address address;
	private BankAccount bankAccount;
	private DebitCards debitCards;
	private CreditCards creditCards;
	
}
