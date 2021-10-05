package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Address {

	@Column(name = "landmark", length = 20)
	private String landmark;
	@Column(name = "zip", length = 20)
	private String zip;
	@Column(name = "country", length = 20)
	private String country;

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [landmark=" + landmark + ", zip=" + zip + ", country=" + country + "]";
	}

}
