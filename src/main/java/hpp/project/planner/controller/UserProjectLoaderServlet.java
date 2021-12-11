package hpp.project.planner.controller;

import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
import hpp.project.planner.entity.User;
import hpp.project.planner.persistence.GenericDao;

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
 *  unit4 lab2
 *
 *@author    EChristenson
 */
@WebServlet(
        name = "index",
        urlPatterns = { "/index" }
)
public class UserProjectLoaderServlet extends HttpServlet {
    List<Project> projects = new ArrayList<>();
    User loggedInUser;

    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        log("inside **init** method printing this msg");


    }
    /**
     *
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        loggedInUser = (User) ses.getAttribute("cognitoUser");

//call with user to get projects
            projects = getProjectsFromUser(loggedInUser);
            ses.setAttribute("projects", projects);

            String url = "/index.jsp";
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }


    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        loggedInUser = (User) ses.getAttribute("cognitoUser");

//call with user to get projects
        projects = getProjectsFromUser(loggedInUser);
        ses.setAttribute("projects", projects);

        String url = "/index.jsp";
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);



    }







    private List<Project> getProjectsFromUser(User LoggedInUser){
        GenericDao pDao = new GenericDao(Project.class);
        projects = pDao.findByPropertyEqual("user",loggedInUser);
        return projects;
    }
}
