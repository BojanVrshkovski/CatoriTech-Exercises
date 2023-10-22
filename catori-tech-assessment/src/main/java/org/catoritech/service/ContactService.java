package org.catoritech.service;

import org.catoritech.entity.Contact;
import org.catoritech.entity.requests.ContactRequest;

import java.util.List;

public interface ContactService {
	List<Contact> readAll();
	Contact readById(Long id);
	ContactRequest create(ContactRequest contact);
}
