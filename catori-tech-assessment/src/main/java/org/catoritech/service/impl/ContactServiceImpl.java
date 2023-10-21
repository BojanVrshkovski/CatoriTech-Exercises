package org.catoritech.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.catoritech.entity.Contact;
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
}
