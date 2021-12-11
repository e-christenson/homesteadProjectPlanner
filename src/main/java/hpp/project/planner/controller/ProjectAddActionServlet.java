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
import java.util.List;

/**
 *  Homestead Project Planer
 *  add user servlet
 *@author    EChristenson
 */
@WebServlet(
        name = "HPPaddProject",
        urlPatterns = { "/HPPaddProject" }
)
public class ProjectAddActionServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao dao;
    //GenericDao userDao;
   // List<Project> projects;
    //List<User> users;
    User loggedInUser;


    /**
     *
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */



    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //info in from web form
        //String email = request.getParameter("email");
    String helper = request.getParameter("helper");
    String store = request.getParameter("store");
        String  projectName = request.getParameter("projectName");
        //String  day = request.getParameter("day");
        String  Wday = request.getParameter("Wday");
        String  Sday = request.getParameter("Sday");
        String  in_out = request.getParameter("in_out");
        String  hot_cold = request.getParameter("hot_cold");
        String  windy = request.getParameter("windy");
        //int editProjectID = Integer.parseInt(request.getParameter("ProjectEditID"));
    String editProjectID =request.getParameter("ProjectEditID");
    if (editProjectID == null){editProjectID="0";}
    int insertOrEdit = Integer.parseInt(editProjectID);

        //setup DB item y or n based on if store items exist
        String storeYn;
        logger.info("STORE ITEM LIST LENGTH "+store.length());
        if (store.length() == 0){
            storeYn="n";
        }else {
            storeYn="y";};



       // userDao = new GenericDao(User.class);
        dao = new GenericDao(Project.class);

        //users = userDao.findByPropertyEqual("email",email);
        loggedInUser = (User) request.getSession().getAttribute("cognitoUser");

        Project newProject = new Project( insertOrEdit, loggedInUser, projectName,  Wday, Sday, helper, storeYn, in_out, hot_cold, windy);
        loggedInUser.addProject(newProject);
        logger.info("is newProject set???  "+newProject);


       int newProjectID = dao.insert(newProject);

        //get back newProject, but now we have project ID.  its project 0 in the list
        //List<Project> insertedNewProject = dao.findByPropertyEqual("id",newProjectID);
        //now that project is added we can add store itmes (tied to project)
        //function to turn store string into array, and set
        //each item as its own row in the store DB table
       // logger.info("project we are using to add store items "+insertedNewProject.get(0));

        //if store is empty we set DB to n
        if (store.length() >1 ){
            setStoreStringToDB(store,newProjectID);
        }






        //get all projects for user and add into session
//projects = dao.findByPropertyEqual("user",loggedInUser.getId());
//request.getSession().setAttribute("projects",projects);

        String url = "/index";

        //testing sc / el
        request.setAttribute("url",url);
        //response.sendRedirect(request.getContextPath()+url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
    }

    public void init() throws ServletException {
    }

    private void setStoreStringToDB(String storeString, int projectID){
        GenericDao dao = new GenericDao(Store.class);
        String[] indItemsStore = storeString.split("\\s+");

        for (String item: indItemsStore ) {
            Store newInsert = new Store(0,projectID,loggedInUser.getId(),item);
           // newProject.addStore(newInsert);
            dao.insert(newInsert);

        }

    }



}