package hpp.project.planner.controller;

import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.User;
import hpp.project.planner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * this class is used to gather data from the DB
 * and then load it into session objects
 * then the index.jsp page is called to display it all
 *
 * @author EChristenson
 */
@WebServlet(
        name = "index",
        urlPatterns = {"/index"}
)
public class IndexLoadServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    List<Project> projects = new ArrayList<>();
    User loggedInUser;

    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        log("inside **init** method printing this msg");


    }


    /**
     * Handles HTTP GET requests.
     * finds whe is logged in, gets their projects, sets to session
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        loggedInUser = (User) ses.getAttribute("cognitoUser");
        projects.clear();

        //call with user to get projects
        projects = getProjectsFromUser(loggedInUser);
        logger.info("Index servlet DOGET--------projects loaded, size is : " + projects.size());
        ses.setAttribute("projects", projects);

        String url = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    /**
     * Handles HTTP doPost requests.
     * <p>
     * users can come into this servelt with both styles of request
     * depending where they are in the app.
     * both methods have same functionality
     * finds whe is logged in, gets their projects, sets to session
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        loggedInUser = (User) ses.getAttribute("cognitoUser");
        projects.clear();
        //call with user to get projects
        projects = getProjectsFromUser(loggedInUser);
        logger.info("Index servlet doPost--------projects loaded, size is : " + projects.size());
        ses.setAttribute("projects", projects);

        String url = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }


    /**
     * send this method a user and it returns
     * that users projects
     *
     * @param LoggedInUser
     * @return
     */

    private List<Project> getProjectsFromUser(User LoggedInUser) {
        GenericDao pDao = new GenericDao(Project.class);
        projects = pDao.findByPropertyEqual("user", loggedInUser);
        return projects;
    }
}
