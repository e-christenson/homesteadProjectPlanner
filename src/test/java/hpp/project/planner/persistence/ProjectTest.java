package hpp.project.planner.persistence;

import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    GenericDao storeDao;

    List<Project> projects;
    List<User> users;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Project.class);
        userDao = new GenericDao(User.class);
        storeDao = new GenericDao(Store.class);

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
        //LocalDate date = new LocalDate.now();
        users = userDao.findByPropertyEqual("email","bob@email.com");
        Project newProject = new Project( 5, users.get(0), "burn the brush pile", null, "y", "y", "y", "y", "y", "y","w" ,0);
    users.get(0).addProject(newProject);
    int id = dao.insert(newProject);
    Project projectWeJustAdded = (Project) dao.getById(id);


        assertEquals(projectWeJustAdded.getProject_name(),newProject.getProject_name());

    }

    @Test
    void updateProject(){
        Project projectToUpdate = (Project) dao.getById(3);
        final String originalProjectName = projectToUpdate.getProject_name();
        projectToUpdate.setProject_name("Take Recyclables out");
        dao.saveOrUpdate(projectToUpdate);
        Project updatedProject = (Project) dao.getById(3);
        assertNotEquals(originalProjectName, updatedProject.getProject_name());


    }




    @Test
    void deleteProject(){


        projects = dao.findByPropertyEqual("id",1);

       // System.out.println("what STORES do we have???????? "+projects.get(0).getStores());


//List<Store> stores =  projects.get(0).getStores();
//projects.get(0).removeStore(stores.get(0));
      //  storeDao.delete(projects.get(0).getStores().get(0));
        dao.delete(projects.get(0));
    //dao.delete(projects.get(0));
    }

}