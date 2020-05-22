package mate.academy.books.dao;

import java.util.List;
import mate.academy.books.model.Author;
import mate.academy.books.model.Book;
import mate.academy.books.model.Genre;

public interface BookDao {
    Book add(Book book);

    Book getByTitle(String title);

    List<Book> getByAuthor(Author author);

    List<Book> getByGenre(Genre genre);
}
