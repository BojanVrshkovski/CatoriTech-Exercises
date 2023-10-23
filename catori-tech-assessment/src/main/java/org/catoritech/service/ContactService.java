package org.catoritech.service;

import org.catoritech.entity.Contact;
import org.catoritech.entity.requests.ContactRequest;

import java.util.List;

public interface ContactService {
	List<Contact> readAll();
	Contact readById(Long id);
	Contact create(ContactRequest contact);
	void deleteById(Long id);
	void updateById(Long id, ContactRequest contactRequest);
	List<Contact> readByFirstNameContainingOrPhoneContaining(String searchTerm)
}
