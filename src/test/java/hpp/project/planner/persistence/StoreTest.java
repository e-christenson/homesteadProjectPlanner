package hpp.project.planner.persistence;
import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
import hpp.project.planner.entity.User;
import hpp.project.planner.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type store dao test.
 */

public class StoreTest {

    GenericDao dao;
    GenericDao projectDao;
    GenericDao storeDao;
    List<Project> projects;
    List<Store>  stores;
    Store store;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Store.class);
        projectDao = new GenericDao(Project.class);
        storeDao = new GenericDao(Store.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    @Test
    void insertNewStoreItem() {

        //projects =  projectDao.findByPropertyEqual("id",1);
        Store newStoreInsert = new Store(0,1,1,"belts");
       // projects.get(0).addStore(newStoreInsert);
        int projectNum = storeDao.insert(newStoreInsert);
        Store pullFromDB = (Store) storeDao.getById(projectNum);
       assertEquals("belts", pullFromDB.getItem());

    }


    @Test
    void getStoreByUser(){
        //get all projects by user
        projects =  projectDao.findByPropertyEqual("id",1);
        //find store items for each project
   stores =  storeDao.findByPropertyEqual("project_id",projects.get(0).getId());


    }
    @Test
    void deleteStoreItem(){
        List<Store> storeToModify = storeDao.findByPropertyEqual("project_id",1);
storeToModify.get(0).setItem("MotorOil");
storeDao.insert(storeToModify.get(0));

        List<Store> storeWeModify = storeDao.findByPropertyEqual("project_id",1);
        assertEquals("motoroil", storeWeModify.get(1).getItem());


    }



}
