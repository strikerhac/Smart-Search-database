package com.lab9.smartsearch;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	private int locId;
	private String country;
	private String region;
	private String city;
	private int postalcode;
	private double latitude;
	private double longitude;
	private int metrocode;
	private int areacode;
	

	public Country() {
		// TODO Auto-generated constructor stub
	}
	
	public Country(int locId, String country, String region, String city, int postalcode, double d,
			double e, int metrocode, int areacode) {
		this.locId = locId;
		this.country = country;
		this.region = region;
		this.city = city;
		this.postalcode = postalcode;
		this.latitude = d;
		this.longitude = e;
		this.metrocode = metrocode;
		this.areacode = areacode;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public int getMetrocode() {
		return metrocode;
	}

	public void setMetrocode(int metrocode) {
		this.metrocode = metrocode;
	}

	public int getAreacode() {
		return areacode;
	}

	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}
	
}
