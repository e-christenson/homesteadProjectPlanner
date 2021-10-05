package edu.matc.persistence;

import edu.matc.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 Data access class to access books
 *
 */
public class BookDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get book by id
     */
    public Book getById(int id) {
        Session session = sessionFactory.openSession();
        Book book = session.get( Book.class, id );
        session.close();
        logger.info("information on book returned by bookDao: " +book);
        return book;
    }

    /**
     * update book
     * @param book  Book to be inserted or updated
     */
    public void saveOrUpdate(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
        logger.info("Save or UPDATE ran with variables: " +book);
    }

    /**
     * update Book
     * @param book  Book to be inserted or updated
     */
    public int insert(Book book) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(book);
        logger.info("Id pulled from insert: "+id);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a book
     * @param book Book to be deleted
     */
    public void delete(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();

    }


    /** Return a list of all books
     *
     * @return All books
     */
    public List<Book> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Book> query = builder.createQuery( Book.class );
        Root<Book> root = query.from( Book.class );
        List<Book> books = session.createQuery( query ).getResultList();

        logger.debug("The list of books " + books);
        session.close();

        return books;


    }



}
