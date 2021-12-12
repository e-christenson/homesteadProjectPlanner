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
import java.util.List;


/**
 *  unit4 lab2
 *
 *@author    EChristenson
 */
@WebServlet(
        name = "projectEdit",
        urlPatterns = { "/projectEdit" }
)
public class ProjectEditDisplayServlet extends HttpServlet {



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
            GenericDao pDao = new GenericDao(Project.class);
            GenericDao sDao = new GenericDao(Store.class);

        String projectId = request.getParameter("projectId");

        Project projectEdit = (Project) pDao.getById(Integer.parseInt(projectId));
        List<Store> stores = sDao.findByPropertyEqual("project_id", projectEdit.getId());

            ses.setAttribute("projectEdit", projectEdit);
            request.setAttribute("storeList", stores);

            String url = "/projectEdit.jsp";




        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        log("inside **init** method printing this msg");


    }


}
