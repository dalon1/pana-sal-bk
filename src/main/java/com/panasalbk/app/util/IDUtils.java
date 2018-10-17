package com.panasalbk.app.util;

import java.util.Random;

public final class IDUtils {
	private static Random RANDOM = new Random();
	// CHECK IF KEEP THEM AS VARIABLES OR CHANGE THEM TO METHOD;
	public final static String createTransactionId() {
		return String.format("%s%d","TXN", RANDOM.nextInt((999_999 - 100_000) + 1) + 100_000);
	}
			
	
	public final static String createCustomerId() {
		return String.format("%s%d","CUT", RANDOM.nextInt((999_999 - 100_000) + 1) + 100_000);
	}
	
	public final static String createAccountId() {
		return String.format("%s%d","ACC", RANDOM.nextInt((999_999 - 100_000) + 1) + 100_000);
	}
}
