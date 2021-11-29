package hpp.project.planner.controller;


import hpp.project.planner.entity.Project;
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
        name = "HPPdeleteProject",
        urlPatterns = { "/HPPdeleteProject" }
)
public class ProjectDeleteActionServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao dao;
    GenericDao userDao;
    List<Project> projects;
    List<User> users;


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
        String email = request.getParameter("email");



        String  projectId = request.getParameter("projectId");
        String  day = request.getParameter("day");
//TODO add logic here
        day = "y";

        userDao = new GenericDao(User.class);
        dao = new GenericDao(Project.class);

        //users = userDao.findByPropertyEqual("email",email);
        users = userDao.findByPropertyEqual("email",email);

projects = dao.findByPropertyEqual("id",projectId);

dao.delete(projects.get(0));

projects = dao.findByPropertyEqual("user", users.get(0));

        //ServletContext sc = getServletContext();
        //sc.setAttribute("projects",projects);

        request.getSession().setAttribute("projects",projects);


        String url = "/index.jsp";

        //testing sc / el
        request.setAttribute("url",url);
        //response.sendRedirect(request.getContextPath()+url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);

    }

    public void init() throws ServletException {

    }


}