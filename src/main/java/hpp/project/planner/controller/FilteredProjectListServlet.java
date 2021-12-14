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
    private final Logger logger = LogManager.getLogger(this.getClass());
List<Project> projects = new ArrayList<>();
    List<Project> wProjects = new ArrayList<>();
    //project list with wind match removed
    List<Project> fProjects = new ArrayList<>();
Weather weather;

//wind score we use as cutoff for filtering

    int wind = 2;

    //hot cutoff.  above 75 is hot
    int hot = 75;

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
        logger.info("FilterProjectListServlet inside GET");
            HttpSession ses= request.getSession();
            User cognitoUser = (User) ses.getAttribute("cognitoUser");
            projects = (List<Project>) ses.getAttribute("projects");

            weather = (Weather) ses.getAttribute("currentWeather");
            fProjects.clear();
            wProjects.clear();


//function to loop through projects in session, pull non-match, return list projects
        removeByWind(projects,weather);
        removeByHot(wProjects,weather);

request.setAttribute("fProjects", fProjects);
//clear the list after we set it


            String url = "/filteredProjects.jsp";


        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    private void removeByWind(List<Project> projects, Weather weather) {

        logger.info("wind score: " + weather.getDataseries().get(0).getWind10mMax());
        //loop through projects, push all BUT calm wind projects to fProjects
        // wind10Max above 2 is high winde
        if (weather.getDataseries().get(0).getWind10mMax() > wind) {
            //sendProjects(projects);
            for (Project project : projects) {
                if (project.getWindy() == null) {
                    wProjects.add(project);
                    logger.info("null MATCH added to fProjects" + fProjects.size());

                } else {
                    if (!project.getWindy().equals("c")) {

                        wProjects.add(project);
                        logger.info("not c MATCH added to fProjects" + fProjects.size());
                    }
                }
            }
        }
    }



    private void removeByHot(List<Project> projects, Weather weather) {

        logger.info("wind score: " + weather.getDataseries().get(0).getWind10mMax());
        //loop through projects, push all BUT calm wind projects to fProjects
        // wind10Max above 2 is high winde
        if (weather.getDataseries().get(0).getTemp2m().getMax() < hot) {
            //sendProjects(projects);
            for (Project project : projects) {
                if (project.getHot_cold() == null) {
                    fProjects.add(project);
                    logger.info("null MATCH in remHOt added to fProjects" + fProjects.size());

                } else {
                    if (!project.getHot_cold().equals("h")) {

                        fProjects.add(project);
                        logger.info("not hot MATCH added to fProjects" + fProjects.size());
                    }
                }
            }
        }
    }







    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        log("inside **init** method printing this msg");


    }


}
