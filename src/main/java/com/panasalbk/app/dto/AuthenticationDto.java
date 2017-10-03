package com.panasalbk.app.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.panasalbk.app.model.id.CustomerId;

public class AuthenticationDto {
	@NotEmpty
	@NotNull
	@NotBlank
	private String emailAddress;
	@NotEmpty
	private String password;
	private CustomerId customerId;
	//private List<Capability> capability;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerId getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerId customerId) {
		this.customerId = customerId;
	}
}
