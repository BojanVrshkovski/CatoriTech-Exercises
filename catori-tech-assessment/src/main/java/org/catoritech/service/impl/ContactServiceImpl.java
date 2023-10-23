package org.catoritech.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.catoritech.entity.Contact;
import org.catoritech.entity.requests.ContactRequest;
import org.catoritech.repository.ContactRepository;
import org.catoritech.service.ContactService;

import java.util.List;

@ApplicationScoped
public class ContactServiceImpl implements ContactService {

	@Inject
	ContactRepository contactRepository;
	@Override
	public List<Contact> readAll() {
		return contactRepository.readAll();
	}

	@Override
	public Contact readById(Long id) {
		return contactRepository.readById(id);
	}

	@Override
	public Contact create(ContactRequest contact) {
		return contactRepository.create(contact);
	}

	@Override
	public void deleteById(Long id) {
		contactRepository.deleteById(id);
	}

	@Override
	public void updateById(Long id, ContactRequest contactRequest) {
		contactRepository.updateById(id,contactRequest);
	}

	@Override
	public List<Contact> readByFirstNameContainingOrPhoneContaining(String searchTerm) {
		return contactRepository.readByFirstNameContainingOrPhoneContaining(searchTerm);
	}
}
