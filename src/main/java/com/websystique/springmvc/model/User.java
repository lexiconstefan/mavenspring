package com.websystique.springmvc.model;

public class User {
	
	private int id;
	private String firstname;
	private String lastname;
	private String municipality;
	private String adress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString(){
		return "[User Firstname= "+getFirstname()+" Lastname = "+getLastname()+" Adress = "+getAdress()+" Municipality = " +getMunicipality()+ "]";
		
	}

}
