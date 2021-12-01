package hpp.project.planner.persistence;

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

class UserDaoTest {
    /**
     * The Dao.
     */
    UserDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets by id sucess.
     */
    @Test
    void getByIdSucess() {
        User user1 = dao.getById(1);

       assertEquals("Bob Dedrich", user1.getName());
       assertEquals("bob@email.com", user1.getEmail());
       assertEquals("lon=-89.224&lat=42.929", user1.getLonLat());
       assertEquals(53536, user1.getZip_code());

    }


    /**
     * Gets by id sucess.

    @Test
    void getByNameSucess() {
        User user1 = dao.getByUserName("Bob Dedrich");

        assertEquals("Bob Dedrich", user1.getName());
        assertEquals("bob@email.com", user1.getEmail());
        assertEquals("password1", user1.getPassword());
        assertEquals(53536, user1.getZip_code());

    }
     */


    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        User user1 = dao.getById(1);
        user1.setName("Not Bob");

        dao.saveOrUpdate(user1);

        user1 = dao.getById(1);

        //verify the isbn update took
        assertEquals("Not Bob", user1.getName());
        //check other known variables to make sure they didn't change
        assertEquals("bob@email.com", user1.getEmail());
        assertEquals("lon=-89.224&lat=42.929", user1.getLonLat());
        assertEquals(53536, user1.getZip_code());

    }

    /**
     * Insert.
     */
    @Test
    void insert() {

        // create new user
        User newUser = new User(0,"Test user", "Test@email.com", "password", 20021);
        dao.insert(newUser);

        //we have no idea of insertions ID bc our sql clear script does not wipe the table....so we grab all books and enter in array
        //original db had 3 entries.  now we should have 4 from insert
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers = (ArrayList<User>) dao.getAll();
        //call the 4th item in the array and see if its the new user
        int usersSize = allUsers.size();
        //figure out how many users on the users array, assign last user in db to variable
        User lastUserInDb = allUsers.get(usersSize-1);
        assertEquals(newUser, lastUserInDb);

    }

    /**
     * Verify successful insert of a user and an project
     */
    @Test
    void insertWithProjectSuccess() {

        // create new user
        User newUser = new User(0,"Fred Flinstone", "Test@email.com", "password", 20021);
        //dao.insert(newUser);

        Project project = new Project(0,newUser,"Mow the lawn","n","y","n","y","n","n","y");

        newUser.addProject(project);

        int id = dao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Fred Flinstone",insertedUser.getName());
        assertEquals(1,insertedUser.getProjects().size());


}



    /**
     * Delete.
     */
    @Test
    void delete() {
        //remove ID one and test
        User user1 = dao.getById(1);
        dao.delete(user1);
        //get all the users from the table.  first user in this array should not match original book 1
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers = (ArrayList<User>) dao.getAll();
        assertNotEquals(user1, allUsers.get(0));
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        //we know there are 3 users in the db from setup.  so we load all into an array and check length is 3
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers = (ArrayList<User>) dao.getAll();
        int totalBooks = allUsers.size();

        assertEquals(3,allUsers.size());

    }
}