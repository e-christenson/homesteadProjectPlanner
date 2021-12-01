package hpp.project.planner.controller;


import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.User;
import hpp.project.planner.persistence.GenericDao;
import hpp.project.planner.persistence.UserDao;
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
import java.util.List;
import java.util.Properties;

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
String helper = request.getParameter("helper");


        String  projectName = request.getParameter("projectName");
        String  day = request.getParameter("day");
//TODO add logic here
        //day = "y";


        userDao = new GenericDao(User.class);
        dao = new GenericDao(Project.class);

        users = userDao.findByPropertyEqual("email",email);
        Project newProject = new Project( 0, users.get(0), projectName,  day, day, helper, "n", "n", "n", "n");
        users.get(0).addProject(newProject);
        logger.info("is newProject set???  "+newProject);
        dao.insert(newProject);

        logger.info("projectAddServlet FROM DATA incoming: "+projectName +" "+day);

projects = dao.findByPropertyEqual("user",users.get(0).getId());

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