package mate.academy.books;

import java.util.List;
import mate.academy.books.lib.Injector;
import mate.academy.books.model.Author;
import mate.academy.books.model.Book;
import mate.academy.books.model.Genre;
import mate.academy.books.service.AuthorService;
import mate.academy.books.service.BookService;
import mate.academy.books.service.GenreService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy.books");

    public static void main(String[] args) {
        var pratchett = new Author();
        pratchett.setName("Pratchett");
        var shirer = new Author();
        shirer.setName("Shirer");
        var authorService = (AuthorService) INJECTOR.getInstance(AuthorService.class);
        authorService.add(pratchett);
        authorService.add(shirer);

        var fantasy = new Genre();
        fantasy.setName("Fantasy");
        var history = new Genre();
        history.setName("History");
        var genreService = (GenreService) INJECTOR.getInstance(GenreService.class);
        genreService.add(fantasy);
        genreService.add(history);

        var book = new Book();
        book.setTitle("The road");
        book.setAuthors(List.of(pratchett, shirer));
        book.setGenre(fantasy);
        var bookService = (BookService) INJECTOR.getInstance(BookService.class);
        bookService.add(book);

        System.out.println(bookService.getByTitle("The road"));
        bookService.getByGenre(fantasy).forEach(System.out::println);
        bookService.getByAuthor(pratchett).forEach(System.out::println);
    }
}
