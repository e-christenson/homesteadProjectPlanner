package hpp.project.planner.persistence;
import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type store dao test.
 */

public class StoreTest {

    GenericDao dao;
    GenericDao projectDao;
    List<Project> projects;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Store.class);
        projectDao = new GenericDao(Project.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    @Test
    void insertNewStoreItem() {
        projects =  projectDao.findByPropertyEqual("id",1);
        Store newStoreInsert = new Store(0,projects.get(0),"belts");
        int projectNum = dao.insert(newStoreInsert);

        Store pullFromDB = (Store) dao.getById(projectNum);

        assertEquals("belts", pullFromDB.getItem());

    }

}
