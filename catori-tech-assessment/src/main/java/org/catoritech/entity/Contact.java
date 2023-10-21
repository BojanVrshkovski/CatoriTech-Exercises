package org.catoritech.entity;

public class Contact {
	public Long id;
	public String name;
	public String lastName;
	public String address;
	public String phoneNumber;
	public String vat;

	public Contact(Long id, String name, String lastName, String address, String phoneNumber, String vat) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.vat = vat;
	}
}
