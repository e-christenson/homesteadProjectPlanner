package hpp.project.planner.persistence;

import hpp.project.planner.entity.User;
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
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        logger.info("session factory  " );
        User user = session.get( User.class, id );
        session.close();
        logger.info("information on book returned by bookDao: " + user);
        return user;
    }

    /**
     * update book
     * @param user  Book to be inserted or updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
        logger.info("Save or UPDATE ran with variables: " + user);
    }

    /**
     * update Book
     * @param user  Book to be inserted or updated
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        logger.info("Id pulled from insert: "+id);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a book
     * @param user Book to be deleted
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();

    }


    /** Return a list of all books
     *
     * @return All books
     */
    public List<User> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        List<User> users = session.createQuery( query ).getResultList();

        logger.debug("The list of books " + users);
        session.close();

        return users;


    }



}
