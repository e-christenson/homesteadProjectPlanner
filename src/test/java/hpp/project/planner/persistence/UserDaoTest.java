package hpp.project.planner.persistence;

import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type Book dao test.
 */

class UserDaoTest {
    /**
     * The Dao.
     */
    BookDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new BookDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets by id sucess.
     */
    @Test
    void getByIdSucess() {
        User retrievedUser = dao.getById(3);
        assertEquals("Java: A Beginner’s Guide (Sixth Edition)", retrievedUser.getTitle());
        assertEquals("Herbert Schilt", retrievedUser.getAuthor());
        assertEquals("978-0071809252", retrievedUser.getIsbn());

        assertEquals(2014, retrievedUser.getPublicationYear());

    }

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        User user1 = dao.getById(1);
        System.out.println("getting book index 1 from DB  " + user1.toString());

        user1.setIsbn("1111");

        dao.saveOrUpdate(user1);

        user1 = dao.getById(1);

        //verify the isbn update took
        assertEquals("1111", user1.getIsbn());

    }

    /**
     * Insert.
     */
    @Test
    void insert() {

        // create new book without ID because db auto assigns this.  insert into db with dao
        User newUser = new User("Test Book", "Test Author", "22", 2021);
        dao.insert(newUser);
        //we have no idea of insertions ID bc our sql clear script does not wipe the table....so we grab all books and enter in array
        //original db had 3 entries.  now we should have 4 from insert
        ArrayList<User> booksArray = new ArrayList<>();
        booksArray = (ArrayList<User>) dao.getAll();
        //call the 4th item in the array and see if its the new book
        User newUserRetreived = booksArray.get(3);
        assertEquals(newUser, newUserRetreived);

    }

    /**
     * Delete.
     */
    @Test
    void delete() {
        //remove ID one and test
        User user1 = dao.getById(1);
        dao.delete(user1);
        //get all the books from the table.  first book in this array should not match original book 1
        ArrayList<User> booksArray = new ArrayList<>();
        booksArray = (ArrayList<User>) dao.getAll();

        assertNotEquals(user1, booksArray.get(0));
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        //we know there are 3 books in the db from setup.  so we load all into an array and check length is 3
        ArrayList<User> booksArray = new ArrayList<>();
        booksArray = (ArrayList<User>) dao.getAll();
        int totalBooks = booksArray.size();

                assertEquals(3,booksArray.size());

    }
}