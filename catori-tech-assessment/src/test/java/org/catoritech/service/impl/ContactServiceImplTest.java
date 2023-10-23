package org.catoritech.service.impl;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.catoritech.entity.Contact;
import org.catoritech.entity.requests.ContactRequest;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ContactServiceImplTest {

	@Inject
	ContactServiceImpl contactService;
	@Inject
	EntityManager entityManager;


	@Test
	public void testReadAll() {
		List<Contact> contacts = contactService.readAll();
		assertEquals(contacts.size(), contacts.size());
	}

	@Test
	public void testReadById() {
		Contact newContact = new Contact(1L,"John","Doe","123 Main St","555-123-4567","12345A");

		Long contactId = newContact.getId();
		Contact retrievedContact = contactService.readById(contactId);

		assertNotNull(retrievedContact);

		assertEquals(1L, retrievedContact.getId());
		assertEquals("John", retrievedContact.getName());
		assertEquals("Doe", retrievedContact.getLastName());
		assertEquals("123 Main St", retrievedContact.getAddress());
		assertEquals("555-123-4567", retrievedContact.getPhoneNumber());
		assertEquals("12345A", retrievedContact.getVat());
	}

	@Test
	@Transactional
	public void testCreateContact_success() {
		ContactRequest contactRequest = new ContactRequest();
		contactRequest.setName("John");
		contactRequest.setLastName("Doe");
		contactRequest.setAddress("123 Main St");
		contactRequest.setPhoneNumber("555-1234");
		contactRequest.setVat("V123456");

		Contact createdContact = contactService.create(contactRequest);
		assertNotNull(createdContact.getId());
	}

	@Test
	@Transactional
	public void testDeleteById() {
		Contact contact = new Contact(1L,"John","Doe","123 Main St","555-123-4567","12345A");

		assertNotNull(contact.getId());

		Long contactId = contact.getId();

		contactService.deleteById(contactId);
	}
}