package org.catoritech.resource;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.HttpHeaders;
import static io.restassured.RestAssured.given;
@QuarkusTest
public class ContactResourceTest {

	@Test
	public void testReadAllContacts_success(){
		given().
			header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
		when().
			get("api/contact/all").
		then().
			statusCode(200);
	}

	@Test
	public void testReadContactById_success(){
		given().
			header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
			pathParam("id",1).
		when().
			get("api/contact/{id}").
		then().
			statusCode(200);
	}
}
