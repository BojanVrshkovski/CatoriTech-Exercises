package org.catoritech.entity.requests;

public class ContactRequest {
	
	public String name;
	public String lastName;
	public String address;
	public String phoneNumber;
	public String vat;

	public ContactRequest() {
	}

	public ContactRequest(String name, String lastName, String address, String phoneNumber, String vat) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.vat = vat;
	}
}
