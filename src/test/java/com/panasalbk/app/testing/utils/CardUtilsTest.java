package com.panasalbk.app.testing.utils;

import org.junit.Test;

import com.panasalbk.app.util.CardUtils;

import org.junit.Assert;

public class CardUtilsTest {
	
	@Test
	public void formatCardNumberSuccess() {
		String cardNumber = "1000100010001000";
		Assert.assertEquals("1000-1000-1000-1000", CardUtils.formatCardNumber(cardNumber));
	}
	
	@Test
	public void maskCardNumberSuccess() {
		String cardNumber = "1000100010001000";
		Assert.assertEquals("****-****-****-1000", CardUtils.maskCardNumber(cardNumber));
	}
}
