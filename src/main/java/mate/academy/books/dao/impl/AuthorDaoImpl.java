package mate.academy.books.dao.impl;

import mate.academy.books.dao.AuthorDao;
import mate.academy.books.exceptions.DataProcessingException;
import mate.academy.books.lib.Dao;
import mate.academy.books.model.Author;
import mate.academy.books.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add author entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
