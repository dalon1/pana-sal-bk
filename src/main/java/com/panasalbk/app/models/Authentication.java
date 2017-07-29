package com.panasalbk.app.models;

public class Authentication {
	private final int MAX_TRIALS = 3;
	
	private int numTrials = MAX_TRIALS;
	private boolean isAuthentic = false;
	private String username;
	private String password;
	private Customer authenticCust;
	
	public int getNumTrials() {
		return numTrials;
	}
	public void setNumTrials(int numTrials) {
		this.numTrials = numTrials;
	}
	public boolean getIsAuthentic() {
		return isAuthentic;
	}
	public void setIsAuthentic(boolean isAuthentic) {
		this.isAuthentic = isAuthentic;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer getAuthenticCust() {
		return authenticCust;
	}
	public void setAuthenticCust(Customer authenticCust) {
		this.authenticCust = authenticCust;
	}
}
