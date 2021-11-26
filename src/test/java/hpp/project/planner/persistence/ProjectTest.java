package hpp.project.planner.persistence;

import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Book dao test.
 */

class ProjectTest {
    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao userDao;
    List<Project> projects;
    List<User> users;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Project.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        //we know there are 3 projects in the db from setup.  so we load all into an array and check length is 3
   projects = dao.getAll();
        int totalProjects = projects.size();

        assertEquals(3, totalProjects);
    }

    /**
     * Gets all projects for an indvidual user.
     */
    @Test
    void getAllForUser() {
        //we know there are 3 projects in the db from setup.  so we load all into an array and check length is 3
        projects = dao.findByPropertyEqual("user",1);
        int totalProjects = projects.size();

        assertEquals(2, totalProjects);
    }

    /**
     * Gets all projects for an indvidual user.
     */
    @Test
    void insertNewProject() {

        users = userDao.findByPropertyEqual("email","bob@email.com");
        Project newProject = new Project( 5, users.get(0), "rake the yard",  "y", "y", "y", "y", "y", "y", "y");
    users.get(0).addProject(newProject);
    int id = dao.insert(newProject);


        assertEquals(2, id);

    }


}