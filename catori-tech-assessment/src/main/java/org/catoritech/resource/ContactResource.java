package org.catoritech.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.catoritech.entity.Contact;
import org.catoritech.entity.requests.ContactRequest;
import org.catoritech.service.ContactService;
import java.util.List;

@Path("/api/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
	@Inject
	ContactService contactService;

	@GET
	@Path("/all")
	public List<Contact> readAllContacts(){
		return contactService.readAll();
	}

	@GET
	@Path("/{id}")
	public Contact readContactById(@PathParam("id") Long id){
		return contactService.readById(id);
	}

	@POST
	@Path("/create")
	public Contact createContact(ContactRequest contactRequest){
		return contactService.create(contactRequest);
	}

	@DELETE
	@Path("/delete/{id}")
	public void deleteContactById(@PathParam("id") Long id){
		contactService.deleteById(id);
	}

	@PUT
	@Path("/update/{id}")
	public void updateContactById(@PathParam("id") Long id,ContactRequest contactRequest){
		contactService.updateById(id,contactRequest);
	}

	@GET
	@Path("/search")
	public List<Contact> searchContacts(@QueryParam("searchTerm") String searchTerm){
		return contactService.readByFirstNameContainingOrPhoneContaining(searchTerm);
	}
}
