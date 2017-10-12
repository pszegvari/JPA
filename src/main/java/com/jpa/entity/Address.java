package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id; 
	
	@Column(name="zipcode")
	private String zipCode;

	@Column(name="settlement")
	private String settlement;
	
	@Column(name="publicplace")
	private String publicPlace;

	@Column(name="publicplacetype")
	private String publicPlaceType;
	
	@Column(name="housenumber")
	private String houseNumber;
	
	@Column(name="addressotherfield")
	private String addressOtherField;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getPublicPlaceType() {
		return publicPlaceType;
	}

	public void setPublicPlaceType(String publicPlaceType) {
		this.publicPlaceType = publicPlaceType;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressOtherField() {
		return addressOtherField;
	}

	public void setAddressOtherField(String addressOtherField) {
		this.addressOtherField = addressOtherField;
	}
	
	
}
