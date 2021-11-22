package hpp.project.planner.persistence;

import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Book dao test.
 */

class ProjectDaoTest {
    /**
     * The Dao.
     */
    ProjectDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new ProjectDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets by id sucess.
     */
    @Test
    void getByIdSuccess() {
        Project project1 = dao.getById(3);

        assertEquals("Take out trash", project1.getProject_name());
        assertEquals(2, project1.getUser().getId());
        assertEquals("y", project1.getMon_fri());
        assertEquals("n", project1.getSat_sun());

    }

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        String newProjectName = "power wash driveway";
        Project projectToUpdate = dao.getById(1);
        projectToUpdate.setProject_name(newProjectName);
        dao.saveOrUpdate(projectToUpdate);
        Project retrievedProject = dao.getById(1);
        assertEquals(newProjectName, retrievedProject.getProject_name());

    }

    /**
     * Insert. a new project
     */
    @Test
    void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Project newProject = new Project(4, user, "rake the yard",  "y", "y", "y", "y", "y", "y", "y");
        user.addProject(newProject);

        int id = dao.insert(newProject);

        assertNotEquals(0, id);
        Project insertedProject = dao.getById(id);
        assertEquals("rake the yard", insertedProject.getProject_name());
        assertNotNull(insertedProject);

    }
    /**
     * Deletes and indv project
     */
    @Test
    void delete() {
        //remove ID one and test
        Project project1 = dao.getById(1);
        dao.delete(project1);
        //get all the projects from the table.  first project in this array should not match original book 1
        ArrayList<Project> allProjects = new ArrayList<>();
        allProjects = (ArrayList<Project>) dao.getAll();
        assertNotEquals(project1, allProjects.get(0));
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        //we know there are 3 projects in the db from setup.  so we load all into an array and check length is 3
        ArrayList<Project> allProjects = new ArrayList<>();
        allProjects = (ArrayList<Project>) dao.getAll();
        int totalBooks = allProjects.size();

        assertEquals(3, allProjects.size());

    }
}