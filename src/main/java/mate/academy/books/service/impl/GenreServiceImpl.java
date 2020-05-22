package mate.academy.books.service.impl;

import mate.academy.books.dao.GenreDao;
import mate.academy.books.lib.Inject;
import mate.academy.books.lib.Service;
import mate.academy.books.model.Genre;
import mate.academy.books.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    private GenreDao genreDao;

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }
}
