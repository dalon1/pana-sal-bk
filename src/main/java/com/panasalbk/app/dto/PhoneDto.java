package com.panasalbk.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.panasalbk.app.util.StringUtils;

public class PhoneDto {
	String areaCode;
	String number;
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@JsonIgnore
	public String getFullNumber() {
		return String.join("", this.areaCode, this.number);
	}
	
	public static PhoneDto toDto(String phoneNumber) {
		if (StringUtils.isEmpty(phoneNumber)) return null;
	
		PhoneDto phone = new PhoneDto();
		phone.setAreaCode(phoneNumber.substring(0, 3));
		phone.setNumber(phoneNumber.substring(3, phoneNumber.length()));
		return phone;
	}
}
