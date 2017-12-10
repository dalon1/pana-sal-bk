package com.panasalbk.app.model;

public class Amount {
	private double amount;
	private String currency;

	public Amount() {
		this.currency = "CAD";
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
