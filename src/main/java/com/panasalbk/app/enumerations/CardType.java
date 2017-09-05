package com.panasalbk.app.enumerations;

public enum CardType {
	DEBIT(0),
	CREDIT(1),
	PREPAID(2); // Currently, not applicable.

	private int cardTypeIndex;
	
	public int getCardTypeIndex() {
		return cardTypeIndex;
	}
	public void setCardTypeIndex(int cardTypeIndex) {
		this.cardTypeIndex = cardTypeIndex;
	}
	
	CardType(int cardTypeIndex) {
		this.cardTypeIndex = cardTypeIndex;
	}
	
	public static CardType getCardType(Integer index) {
		if (index == null) return null;
		for (CardType cardType : CardType.values()) {
			if (cardType.getCardTypeIndex() == index.intValue())
				return cardType;
		}
		return null;
	}
}
