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
 *
 *  ****warning********
 *  this class will make your eyes bleed java Sherpa...
 *  its the last thing I wrote and I could prob spend
 *  a week improving / breaking it up / adding more conditions.
 *  and if I understood concurrent action on arrayLists this could be
 *  much simpler haha.
 *
 *
 *  this class takess the list of ALL projects and then begins
 *  removing projects based of Weather (at users zip ) conditions happening today
 *
 *
 */
@WebServlet(
        name = "fProjects",
        urlPatterns = { "/fProjects" }
)
public class FilteredProjectListServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
List<Project> allProjects = new ArrayList<>();
    //project list with wind match removed
List<Project> wProjects = new ArrayList<>();

    //project list with hot match removed
    List<Project> hProjects = new ArrayList<>();

    //project list with cold match removed
    List<Project> fProjects = new ArrayList<>();
Weather weather;

//wind score we use as cutoff for filtering

    int wind = 2;

    //hot cutoff.  above 75 is hot
    int hot = 75;

    int cold = 32;


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
        int removedWind;
        int removedHot;
        int removedCold;

        logger.info("FilterProjectListServlet inside GET");
            HttpSession ses= request.getSession();
            User cognitoUser = (User) ses.getAttribute("cognitoUser");
            allProjects = (List<Project>) ses.getAttribute("projects");

            weather = (Weather) ses.getAttribute("currentWeather");
            fProjects.clear();
            wProjects.clear();
            hProjects.clear();


//function to loop through projects in session, pull non-match, return list projects
        if (cognitoUser != null) {
            removeByWind(allProjects, weather);
            removedWind = allProjects.size() - wProjects.size();

            removeByHot(wProjects, weather);
            removedHot = wProjects.size() - hProjects.size();

            removeByCold(hProjects, weather);
            removedCold = hProjects.size() - fProjects.size();

            request.setAttribute("fProjects", fProjects);
            request.setAttribute("removedWind", removedWind);
            request.setAttribute("removedHot", removedHot);
            request.setAttribute("removedCold", removedCold);
//clear the list after we set it
        }

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
                    logger.info("null MATCH added to WWWWWW wProjects" + wProjects.size());

                } else {
                    if (!project.getWindy().equals("c")) {

                        wProjects.add(project);
                        logger.info("not c MATCH added to WWWW wProjects" + wProjects.size());
                    }
                }
            }
        } else {
            wProjects = projects;
        }
    }



    private void removeByHot(List<Project> projects, Weather weather) {

        logger.info("max temp score: " + weather.getDataseries().get(0).getTemp2m().getMax());
        //loop through projects, push all BUT calm wind projects to fProjects
        // wind10Max above 2 is high winde
        if (weather.getDataseries().get(0).getTemp2m().getMax() < hot) {
            //sendProjects(projects);
            for (Project project : projects) {
                if (project.getHot_cold() == null) {
                    hProjects.add(project);
                    logger.info("null MATCH in remHOt added to HHHH hProjects" + hProjects.size());

                } else {
                    if (!project.getHot_cold().equals("h")) {

                        hProjects.add(project);
                        logger.info("not hot MATCH added to HHHH hProjects" + hProjects.size());
                    }
                }
            }
        } else {
            hProjects = projects;
        }
    }

    private void removeByCold(List<Project> projects, Weather weather) {

        logger.info("inside removeBycold api low temp === " + weather.getDataseries().get(0).getTemp2m().getMin());
        //loop through projects, push all BUT calm wind projects to fProjects
        // wind10Max above 2 is high winde
        if (weather.getDataseries().get(0).getTemp2m().getMin() > cold) {
            //sendProjects(projects);
            logger.info("inside if, we are above the cold cutoff condition");
            for (Project project : projects) {
                if (project.getHot_cold() == null) {
                    fProjects.add(project);
                    logger.info("null MATCH in remCold added to fProjects" + fProjects.size());

                } else {
                    if (!project.getHot_cold().equals("c")) {

                        fProjects.add(project);
                        logger.info("not cold MATCH added to fProjects" + fProjects.size());
                    }
                }
            }
        } else {
            fProjects = projects;
        }
    }





    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        log("inside **init** method printing this msg");


    }


}
