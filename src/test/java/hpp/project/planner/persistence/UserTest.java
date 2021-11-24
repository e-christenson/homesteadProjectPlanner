package hpp.project.planner.persistence;

import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type Book dao test.
 */

class UserTest {
    /**
     * The Dao.
     */
    GenericDao dao;
    List<User> users;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }



    /**
     * Gets all.
     */
    @Test
    void getUserIdByEmail() {
        //we know there are 3 users in the db from setup.  so we load all into an array and check length is 3
        users = dao.findByPropertyEqual("email","bob@email.com");
        int id = users.get(0).getId();

        assertEquals(1,id);

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        //we know there are 3 users in the db from setup.  so we load all into an array and check length is 3
        users = dao.getAll();
        int totalUsers = users.size();

        assertEquals(3,totalUsers);

    }


}