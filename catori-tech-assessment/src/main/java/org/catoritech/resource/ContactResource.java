package org.catoritech.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.catoritech.service.ContactService;

@Path("/api/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
	@Inject
	ContactService contactService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllEntities() {
		return "HELLOOO";
	}
}
