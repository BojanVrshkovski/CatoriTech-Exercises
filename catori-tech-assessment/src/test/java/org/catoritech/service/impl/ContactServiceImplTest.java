package org.catoritech.service.impl;

import io.quarkus.test.junit.QuarkusTest;
import org.catoritech.entity.Contact;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ContactServiceImplTest {

	@Inject
	ContactServiceImpl contactService;


	@Test
	public void testReadAll() {
		List<Contact> contacts = contactService.readAll();
		assertEquals(contacts.size(), contacts.size());
	}
}