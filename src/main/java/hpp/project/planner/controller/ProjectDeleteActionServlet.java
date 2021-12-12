package hpp.project.planner.controller;


import hpp.project.planner.entity.Project;
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
    List<Project> projects;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //project to delete ID sent over in the doGet
        String projectId = request.getParameter("projectId");
        //method to delete project
        deleteUserProject(projectId);

        //fwd back to index servlet to refresh users projects
        String url = "/index";
        request.setAttribute("url", url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void init() throws ServletException {
    }


    private void deleteUserProject(String projectId) {
        //turn project ID into object
        dao = new GenericDao(Project.class);
        projects = dao.findByPropertyEqual("id", projectId);
        //one project returned by id, delete first item in projects
        dao.delete(projects.get(0));
    }


}