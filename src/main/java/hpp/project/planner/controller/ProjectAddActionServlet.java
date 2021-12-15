package hpp.project.planner.controller;


import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
import hpp.project.planner.entity.User;
import hpp.project.planner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Homestead Project Planer
 * add user servlet
 *
 * @author EChristenson
 */
@WebServlet(
        name = "HPPaddProject",
        urlPatterns = {"/HPPaddProject"}
)
public class ProjectAddActionServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    //GenericDao dao;
    User loggedInUser;
    int newProjectID;
    GenericDao dao = new GenericDao(Project.class);
    LocalDate date;


    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loggedInUser = (User) request.getSession().getAttribute("cognitoUser");
        //info in from web form loaded into variables

        String helper = request.getParameter("helper");
        String store = request.getParameter("store");
        String storeFlag = null;
        if (store.length() > 1) {
            storeFlag = "y";
        }

        String projectName = request.getParameter("projectName");
        String Wday = request.getParameter("Wday");
        String Sday = request.getParameter("Sday");
        String in_out = request.getParameter("in_out");
        String hot_cold = request.getParameter("hot_cold");
        String windy = request.getParameter("windy");

        //this servlet can add AND edit projects so this could be null
        String editProjectID = request.getParameter("projectEditID");

        //need this above in int, but could be null
        if (editProjectID == null) {
            //new project set at zero 0
            editProjectID = "0";
            date = LocalDate.now();
        } else {
            //if we edit project we need its original data to keep that
            date = LocalDate.parse(request.getParameter("date"));
        }
        int editOrUpdateID = Integer.parseInt(editProjectID);


        logger.info("STORE ITEM LIST LENGTH " + store.length());

        //setting up new project or edited project (both are a project)
        Project newProject = new Project(editOrUpdateID, loggedInUser, projectName, date, Wday, Sday, helper, storeFlag, in_out, hot_cold, windy, 0);
        loggedInUser.addProject(newProject);
        logger.info("is newProject set???  " + newProject);

        // here we decide if we are inserting new or doing an edit

        if (editOrUpdateID == 0) {
            //a new project
            editOrUpdateID = dao.insert(newProject);
        } else {
            dao.saveOrUpdate(newProject);

        }



        //if store contains items, now we have project ID we can insert
        //store items into their table

        if (store.length() > 1) {
            setStoreStringToDB(store, editOrUpdateID);
        }


        String url = "/index";
        request.setAttribute("url", url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void init() throws ServletException {
    }


    /**
     * this method takes a string, splits it into words by (space)
     * then each word is put into a store DB table
     * @param storeString
     * @param projectID
     */
    private void setStoreStringToDB(String storeString, int projectID) {
        GenericDao dao = new GenericDao(Store.class);
        String[] indItemsStore = storeString.split("\\s+");

        for (String item : indItemsStore) {
            Store newInsert = new Store(0, projectID, loggedInUser.getId(), item);
            // newProject.addStore(newInsert);
            dao.insert(newInsert);

        }

    }


}