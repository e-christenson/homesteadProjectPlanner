package hpp.project.planner.controller;

import hpp.project.planner.com.zipCode.Weather;
import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
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
 *  unit4 lab2
 *
 *@author    EChristenson
 */
@WebServlet(
        name = "fProjects",
        urlPatterns = { "/fProjects" }
)
public class FilteredProjectListServlet extends HttpServlet {
List<Project> projects = new ArrayList<>();
    List<Project> fProjects = new ArrayList<>();
Weather weather;
    private final Logger logger = LogManager.getLogger(this.getClass());
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
            User cognitoUser = (User) ses.getAttribute("cognitoUser");
            projects = (List<Project>) ses.getAttribute("projects");
            weather = (Weather) ses.getAttribute("currentWeather");


//function to loop through projects in session, pull non-match, return list projects
        fProjects = removeByWind(projects,weather);

ses.setAttribute("fProjects", fProjects);

            String url = "/filteredProjects.jsp";




        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    private List<Project> removeByWind(List<Project> projects, Weather weather) {

        //if we have high wind, remove projects flagged for calm wind
        if (weather.getDataseries().get(0).getWind10mMax() > 2) {

            for (Project project : projects) {

                if (project.getWindy() == "c") {
                    logger.info("matching CCCCCCCCCCCCCCCC wind");
                  System.out.println("CCC size of ProjectList before remove"+projects.size());
                    projects.remove(this);
                    System.out.println("CCC size of ProjectList after remove"+projects.size());
                }

            }
        }
        return projects;
    }




    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        log("inside **init** method printing this msg");


    }


}
