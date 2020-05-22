package mate.academy.books.service.impl;

import mate.academy.books.dao.AuthorDao;
import mate.academy.books.lib.Inject;
import mate.academy.books.lib.Service;
import mate.academy.books.model.Author;
import mate.academy.books.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    private AuthorDao authorDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }
}
