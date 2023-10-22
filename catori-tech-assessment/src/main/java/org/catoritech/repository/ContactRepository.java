package org.catoritech.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.catoritech.entity.Contact;
import org.catoritech.entity.requests.ContactRequest;

import java.util.List;

@ApplicationScoped
public class ContactRepository {
	@Inject
	EntityManager entityManager;

	public List<Contact> readAll() {
		return entityManager.createQuery("SELECT e FROM Contact e", Contact.class).getResultList();
	}

	public Contact readById(Long id) {
		return entityManager.createQuery("SELECT e FROM Contact e WHERE e.id = :id", Contact.class)
		                    .setParameter("id", id)
		                    .getSingleResult();
	}

	@Transactional
	public Contact create(ContactRequest contactRequest) {
		Contact contact = new Contact();
		contact.setName(contactRequest.getName());
		contact.setLastName(contactRequest.getLastName());
		contact.setAddress(contactRequest.getAddress());
		contact.setPhoneNumber(contactRequest.getPhoneNumber());
		contact.setVat(contactRequest.getVat());

		entityManager.persist(contact);

		return contact;
	}
}
