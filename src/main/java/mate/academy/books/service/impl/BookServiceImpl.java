package mate.academy.books.service.impl;

import java.util.List;
import mate.academy.books.dao.BookDao;
import mate.academy.books.lib.Inject;
import mate.academy.books.lib.Service;
import mate.academy.books.model.Author;
import mate.academy.books.model.Book;
import mate.academy.books.model.Genre;
import mate.academy.books.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public Book getByTitle(String title) {
        return bookDao.getByTitle(title);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return bookDao.getByAuthor(author);
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        return bookDao.getByGenre(genre);
    }
}
