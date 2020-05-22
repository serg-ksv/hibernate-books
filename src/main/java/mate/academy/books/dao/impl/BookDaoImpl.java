package mate.academy.books.dao.impl;

import java.util.List;
import mate.academy.books.dao.BookDao;
import mate.academy.books.exceptions.DataProcessingException;
import mate.academy.books.lib.Dao;
import mate.academy.books.model.Author;
import mate.academy.books.model.Book;
import mate.academy.books.model.Genre;
import mate.academy.books.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add book entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getByTitle(String title) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createQuery("from Book where title = :title");
            query.setParameter("title", title);
            return (Book) query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't retrieve book.", e);
        }
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createQuery("from Book where :author in authors");
            query.setParameter("author", author);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't retrieve books.", e);
        }
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            var query = session.createQuery("from Book where genre = :genre");
            query.setParameter("genre", genre);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't retrieve books.", e);
        }
    }
}
