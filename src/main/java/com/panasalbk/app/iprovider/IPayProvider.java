package com.panasalbk.app.iprovider;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.Customer;

@WrittenBy(
		author="Dannel Alon",
		date="01/04/2017",
		comment="Interface provider")
public interface IPayProvider {
	public void start();
	public boolean payCreditCard(Customer cust, CreditCard creditCard);
	public boolean payBill(Customer cust);
	
}
