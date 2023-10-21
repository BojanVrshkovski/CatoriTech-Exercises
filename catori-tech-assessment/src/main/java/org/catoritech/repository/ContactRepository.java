package org.catoritech.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.catoritech.entity.Contact;

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
}
