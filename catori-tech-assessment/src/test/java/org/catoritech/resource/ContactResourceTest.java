package org.catoritech.resource;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.HttpHeaders;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
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
			pathParam("id",2).
		when().
			get("api/contact/{id}").
		then().
			statusCode(200).
			body("name", is("Bojan"));
	}

	@Test
	public void testCreateContact_success(){
		given()
			.contentType("application/json")
			.body("{\"name\":\"John\", \"lastName\":\"Doe\", \"address\":\"123 Main St\", \"phoneNumber\":\"555-1234\", \"vat\":\"V123456\"}").
		when()
			.post("/api/contact/create").
		then()
			.statusCode(200)
			.body("name", is("John"));
	}

	@Test
	public void testDeleteContact_success(){
		given()
			.contentType("application/json").
			pathParam("id",1).
		when()
			.delete("/api/contact/delete/{id}").
		then()
			.statusCode(204);
	}

	@Test
	public void testUpdateContact_success(){
		given()
			.contentType("application/json")
			.pathParam("id",1)
			.body("{\"name\":\"John\", \"lastName\":\"Doe\", \"address\":\"123 Main St\", \"phoneNumber\":\"555-1234\", \"vat\":\"V123456\"}").
		when()
			.put("/api/contact/update/{id}").
		then()
			.statusCode(204);
	}
}
