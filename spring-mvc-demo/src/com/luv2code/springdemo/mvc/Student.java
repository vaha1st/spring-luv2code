package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	
	private LinkedHashMap<String, String> countryOptions;
	
	private String country;
	
	private String favoriteLang;
	
	private String[] operationalSystem;
	
	public Student() {
		
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("RU", "Russia");


	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}


	public String getFavoriteLang() {
		return favoriteLang;
	}


	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}


	public String[] getOperationalSystem() {
		return operationalSystem;
	}


	public void setOperationalSystem(String[] operationalSystem) {
		this.operationalSystem = operationalSystem;
	}
	
	
	
	
	


}
