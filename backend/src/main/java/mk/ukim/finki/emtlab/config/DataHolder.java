package mk.ukim.finki.emtlab.config;

import lombok.AllArgsConstructor;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.model.enumerations.Category;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.List;

@Component
@AllArgsConstructor
public class DataHolder {

    private List<Author> authors;
    private List<Book> books;
    private List<Country> countries;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    @PostConstruct
    public void init() {;
        Country c1 = new Country("Macedonia","Europe");
        Country c2 = new Country("Spain","Europe");
        Country c3 = new Country("Colombia","South America");
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countryRepository.saveAll(countries);

        Author a1 = new Author("Elizabeth","Gilbert",c1);
        Author a2 = new Author("Jullie" ," James",c2);
        Author a3 = new Author("Jane", "Austine",c3);
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authorRepository.saveAll(authors);

        Book b1 = new Book("Eat, pray, love", Category.BIOGRAPHY,a1,300);
        Book b2 = new Book("Pride and prejudice", Category.BIOGRAPHY,a3,20);
        Book b3 = new Book("La la land", Category.NOVEL,a3,50);
        Book b4 = new Book("About that night", Category.DRAMA,a2,100);
        Book b5 = new Book("Suddenly One Summer", Category.THRILLER,a2,300);
        Book b6 = new Book("1776", Category.HISTORY,a3,500);
        Book b7 = new Book("Blue Highways", Category.DRAMA,a1,100);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        bookRepository.saveAll(books);
    }

}
