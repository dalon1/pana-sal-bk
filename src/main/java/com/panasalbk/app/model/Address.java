package com.panasalbk.app.model;

/**
 * Latest edition date: 06/02/17
 * Address Class
 * Dependency to Customer Class
 * @author AloniD
 * 
 */

public class Address {

	/*
	 * >> Attributes
	 */
	private String streetNumber;
	private String streetName;
	private String placeNumber;
	private String place;
	private String city;
	private String province;
	private String postalCode;
	
	/*
	 * >> Properties
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/*
	 * >> Constructor
	 */
	public Address(String valStNum, String valStName, String valPlace,
			String valCity, String valProv, String valPC) {
		setStreetNumber(valStNum);
		setStreetName(valStName);
		setPlace(valPlace);
		setCity(valCity);
		setProvince(valProv);
		setPostalCode(valPC);
	}

	public String getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(String placeNumber) {
		this.placeNumber = placeNumber;
	}
	
}
