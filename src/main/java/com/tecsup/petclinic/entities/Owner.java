package com.tecsup.petclinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "owners")
public class Owner {
		
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String nombre;
	@Column(name="last_name")
	private String apellido;
	private String address;
	private String city;
	private String telephone;
	
	public Owner() {
		
	}

	public Owner(long id, String nombre, String apellido, String address, String city, String telephone) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner(String nombre, String apellido, String address, String city, String telephone) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", address=" + address + ", city="
				+ city + ", telephone=" + telephone + "]";
	}
	

}
