package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped//meaning one instance per class
public class BookRepository {

    @ConfigProperty(name = "books.genre",defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks(){
        return List.of(
          new Book(1,"Understanding Quarkus","Antonio",2020,genre),
          new Book(2,"Understanding Quarkus","Antonio",2020,genre),
          new Book(3,"Understanding Quarkus","Antonio",2020,genre),
          new Book(4,"Understanding Quarkus","Antonio",2020,genre)
        );
    }

    public int countAllBooks(){
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
