package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;


@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)//this means that the path returns JSON
public class BookResource {

    @Inject
    BookRepository repository;
    @Inject
    Logger logger;

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "Hello RESTEasy";
//    }

    @GET
    public List<Book> getAllBooks(){
        logger.info("Returning all books");
        return repository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        logger.info("Number of books");
        return repository.countAllBooks();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        logger.info("Returning book with id "+id);
        return repository.getBook(id);
    }
}
