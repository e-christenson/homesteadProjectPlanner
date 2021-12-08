package hpp.project.planner.controller;


import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.User;
import hpp.project.planner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Homestead Project Planer
 * add user servlet
 *
 * @author EChristenson
 */
@WebServlet(
        name = "HPPdeleteProject",
        urlPatterns = {"/HPPdeleteProject"}
)
public class ProjectDeleteActionServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao dao;
    GenericDao userDao;
    List<Project> projects;
    List<User> users;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();

        String action = request.getServletPath();
        User loggedInUser = (User) ses.getAttribute("cognitoUser");
        String email = loggedInUser.getEmail();

        String projectId = request.getParameter("projectId");
        logger.debug("email/projectID from get session call "+email +" id: "+projectId);
        projects = deleteUserProject(email, projectId);
        request.getSession().setAttribute("projects", projects);

        /* try {
            switch (action) {

                case "/delete":
                    projects = deleteUser(email, projectId);
                    break;

            }
            request.getSession().setAttribute("projects", projects);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } */

        String url = "/index.jsp";
        request.setAttribute("url", url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }



    public void init() throws ServletException {

    }


   private List<Project> deleteUserProject(String email, String projectId) {
       userDao = new GenericDao(User.class);
       dao = new GenericDao(Project.class);

       projects = dao.findByPropertyEqual("id", projectId);

       dao.delete(projects.get(0));

       //get all projects for the user and set new list into the session
       users = userDao.findByPropertyEqual("email", email);
       projects = dao.findByPropertyEqual("user", users.get(0));

       return projects;

    }


}