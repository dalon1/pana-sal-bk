package com.panasalbk.app.enumeration;

public enum AccountType {
	CHECKING(0),
	SAVING(1);
	
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	AccountType(int index) {
		this.index = index;
	}
	
	public static AccountType getAccountType(Integer index) {
		if (index == null) return null;
		for (AccountType accountType : AccountType.values()) {
			if (accountType.getIndex() == index.intValue())
				return accountType;
		}
		return null;
	}
}
