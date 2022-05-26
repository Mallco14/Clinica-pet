package com.tecsup.petclinic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity(name = "owner")
public class Owner {
		
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String first_name;
	private String last_name;
	private String adress;
	private String city;
	private String phone;
	


	public Owner(String first_name, String last_name, String adress, String city, String phone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.adress = adress;
		this.city = city;
		this.phone = phone;
		
	}



	public Owner(long id, String first_name, String last_name, String adress, String city, String phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.adress = adress;
		this.city = city;
		this.phone = phone;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Owner [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", adress=" + adress
				+ ", city=" + city + ", phone=" + phone + "]";
	}
	
	

	
	
	

}
