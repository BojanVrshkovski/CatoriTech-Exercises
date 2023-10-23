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
	public void testReadAll_success() {
		List<Contact> contacts = contactService.readAll();
		assertEquals(contacts.size(), contacts.size());
	}

	@Test
	public void testReadById_success() {
		Contact newContact = new Contact(2L,"Bojan","Vrshkovski","Andrea Jovanoski","071123345","333BV");

		Long contactId = newContact.getId();
		Contact retrievedContact = contactService.readById(contactId);

		assertNotNull(retrievedContact);

		assertEquals(2L, retrievedContact.getId());
		assertEquals("Bojan", retrievedContact.getName());
		assertEquals("Vrshkovski", retrievedContact.getLastName());
		assertEquals("Andrea Jovanoski", retrievedContact.getAddress());
		assertEquals("071123345", retrievedContact.getPhoneNumber());
		assertEquals("333BV", retrievedContact.getVat());
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
	public void testDeleteById_success() {
		Contact contact = new Contact(1L,"John","Doe","123 Main St","555-123-4567","12345A");

		assertNotNull(contact.getId());

		Long contactId = contact.getId();

		contactService.deleteById(contactId);
	}
}