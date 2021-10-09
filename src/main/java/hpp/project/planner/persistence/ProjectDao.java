package hpp.project.planner.persistence;

import hpp.project.planner.entity.Project;
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
public class ProjectDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get book by id
     */
    public Project getById(int id) {
        Session session = sessionFactory.openSession();

        Project project = session.get( Project.class, id );
        session.close();
        logger.info("information on book returned by bookDao getById method: " + project);
        return project;
    }

    /**
     * update book
     * @param project  Book to be inserted or updated
     */
    public void saveOrUpdate(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
        logger.info("Save or UPDATE ran with variables: " + project);
    }

    /**
     * update Book
     * @param project  Book to be inserted or updated
     */
    public int insert(Project project) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(project);
        logger.info("Id pulled from insert: "+id);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a book
     * @param project Book to be deleted
     */
    public void delete(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();

    }


    /** Return a list of all books
     *
     * @return All books
     */
    public List<Project> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Project> query = builder.createQuery( Project.class );
        Root<Project> root = query.from( Project.class );
        List<Project> projects = session.createQuery( query ).getResultList();

        logger.debug("The list of books " + projects);
        session.close();

        return projects;


    }



}
