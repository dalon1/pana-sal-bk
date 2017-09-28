package com.panasalbk.app.model;

import com.panasalbk.app.util.StringUtils;

public class CustomerName {
	private String firstName;
	private String middleName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return 	StringUtils.isEmpty(this.middleName) ? 
				String.format("%s %s", this.firstName, this.lastName) :
				String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
	}
}
