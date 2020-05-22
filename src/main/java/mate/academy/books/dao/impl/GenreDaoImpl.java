package mate.academy.books.dao.impl;

import mate.academy.books.dao.GenreDao;
import mate.academy.books.exceptions.DataProcessingException;
import mate.academy.books.lib.Dao;
import mate.academy.books.model.Genre;
import mate.academy.books.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre add(Genre genre) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(genre);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add genre entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
