package com.panasalbk.app.models.abstracts;

import com.panasalbk.app.annotations.WrittenBy;
import com.panasalbk.app.models.ids.CustomerId;
import java.util.Date;

@WrittenBy(
		author="Dannel",
		date="19/03/2017",
		comment="Abstract class")
public abstract class Card {
	/*
	 * Attributes >>
	 */
	protected CustomerId customerId;
	protected String brand;
	protected String cardType;
	protected String cardNumber;
	protected String cardNumberMasked;
	protected String pin;
	protected String cardHolder;
	protected Date expireDate;
	protected Date validFromDate;
	protected boolean isTap;
	
	/*
	 * Properties >>
	 */
	public CustomerId getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerId customerId) {
		this.customerId = customerId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardNumberMasked() {
		return cardNumberMasked;
	}
	public void setCardNumberMasked(String cardNumberMasked) {
		this.cardNumberMasked = cardNumberMasked;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Date getValidFromDate() {
		return validFromDate;
	}
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}
	public boolean isTap() {
		return isTap;
	}
	public void setTap(boolean isTap) {
		this.isTap = isTap;
	}
	
	/*
	 * Instance Methods >>
	 */
	//public abstract void viewDetails();
	//TODO pass it to an another class for card format
	public static String formatCardDate(Date date) {
		final int MONTH_NORMALIZATION = 1;
		String month = Integer.toString(date.getMonth() + MONTH_NORMALIZATION);
		String year = Integer.toString(date.getYear()).substring(2);
		String dateCardFormat = month.length() == 1 ?
				String.format("0%s/", month) : String.format("%s/", month);
		dateCardFormat += year;
		return dateCardFormat;
	}
}
