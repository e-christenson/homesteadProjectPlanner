package edu.matc.persistence;

import edu.matc.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The type Book dao test.
 */

class BookDaoTest {
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
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Gets by id sucess.
     */
    @Test
    void getByIdSucess() {
        Book retrievedBook = dao.getById(3);
        assertEquals("Java: A Beginner’s Guide (Sixth Edition)", retrievedBook.getTitle());
        assertEquals("Herbert Schilt", retrievedBook.getAuthor());
        assertEquals("978-0071809252", retrievedBook.getIsbn());

        assertEquals(2014, retrievedBook.getPublicationYear());

    }

    /**
     * Save or update.
     */
    @Test
    void saveOrUpdate() {
        Book book1 = dao.getById(1);
        System.out.println("getting book index 1 from DB  " + book1.toString());

        book1.setIsbn("1111");

        dao.saveOrUpdate(book1);

        book1 = dao.getById(1);

        //verify the isbn update took
        assertEquals("1111", book1.getIsbn());

    }

    /**
     * Insert.
     */
    @Test
    void insert() {

        // create new book without ID because db auto assigns this.  insert into db with dao
        Book newBook = new Book("Test Book", "Test Author", "123456789", 2021);
        dao.insert(newBook);
        //we have no idea of insertions ID bc our sql clear script does not wipe the table....so we grab all books and enter in array
        //original db had 3 entries.  now we should have 4 from insert
        ArrayList<Book> booksArray = new ArrayList<>();
        booksArray = (ArrayList<Book>) dao.getAll();
        //call the 4th item in the array and see if its the new book
        Book newBookRetreived = booksArray.get(3);
        assertEquals(newBook, newBookRetreived);

    }

    /**
     * Delete.
     */
    @Test
    void delete() {
        //remove ID one and test
        Book book1 = dao.getById(1);
        dao.delete(book1);
        //get all the books from the table.  first book in this array should not match original book 1
        ArrayList<Book> booksArray = new ArrayList<>();
        booksArray = (ArrayList<Book>) dao.getAll();

        assertNotEquals(book1, booksArray.get(0));
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        //we know there are 3 books in the db from setup.  so we load all into an array and check length is 3
        ArrayList<Book> booksArray = new ArrayList<>();
        booksArray = (ArrayList<Book>) dao.getAll();
        int totalBooks = booksArray.size();

                assertEquals(3,booksArray.size());

    }
}