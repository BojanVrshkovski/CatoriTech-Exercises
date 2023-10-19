package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testGetAllBooks() {
        given()
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
        when()
          .get("api/books").
        then()
          .statusCode(200)
          .body("size()",is(4));//size() counts the number of elements
    }

    @Test
    public void testCountAllBooks() {
        given()
          .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
          when()
          .get("api/books/count").
          then()
          .statusCode(200)
          .body(is("4"));
    }

    @Test
    public void testGetABook() {
        given()
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .pathParam("id",1).//here we define the path param we are searching for
        when()
          .get("api/books/{id}").
          then()
          .statusCode(200)
          .body("title",is("Understanding Quarkus"));//we are checking if the title is Understanding Quarkus
    }

}