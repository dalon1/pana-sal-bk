package com.panasalbk.app.util;

import com.panasalbk.app.constant.EBankingConstants;

public class CardUtils {
	
	public static String maskCardNumber(String cardNumber) {
		if (StringUtils.isEmpty(cardNumber)
				&& cardNumber.length() != EBankingConstants.CARD_NUMBER_LENGTH) return null;
		
		String maskedCardNumber = "";
		// TODO need code refactoring for efficiency
		for (int i = 0; i < cardNumber.length(); i++) {
			maskedCardNumber += i < EBankingConstants.CARD_NUMBER_LENGTH - 4 ?
					"*": cardNumber.charAt(i);
			if ((i + 1) % 4 == 0 && i != (cardNumber.length() -1))
				maskedCardNumber += "-";
		}
		return maskedCardNumber;
	}
	
	public static String formatCardNumber(String cardNumber) {
		if (StringUtils.isEmpty(cardNumber)
				&& cardNumber.length() != EBankingConstants.CARD_NUMBER_LENGTH) return null;
		
		String maskedCardNumber = "";
		for (int i = 0; i < cardNumber.length(); i++) {
			maskedCardNumber += cardNumber.charAt(i);
			if ((i + 1) % 4 == 0 && i != (cardNumber.length() -1))
				maskedCardNumber += "-";
		}
		return maskedCardNumber;
	}

}
