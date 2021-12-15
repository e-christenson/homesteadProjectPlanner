package hpp.project.planner.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import hpp.project.planner.com.zipCode.Weather;
import hpp.project.planner.entity.User;
import hpp.project.planner.persistence.GenericDao;
import hpp.project.planner.persistence.WeatherApiDao;
import hpp.project.planner.persistence.ZipApiDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Homestead Project Planer
 * add user servlet
 *
 * @author EChristenson
 */
@WebServlet(
        name = "HPPaddUser",
        urlPatterns = {"/HPPaddUser"}
)
public class UserAddActionServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        //info in from web form
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        int zip_code = Integer.parseInt(request.getParameter("zip_code"));

        String longLat = getLocation(zip_code);
//setup new user and add to DB
        User newUserAdd = new User(0, name, email, longLat, zip_code);

        GenericDao dao;
        dao = new GenericDao(User.class);
        int id = dao.insert(newUserAdd);
        logger.info("!!!NEW!!! user inserted, ID = " + id);
        //add new user to session, get weather for new user and add to session
        request.getSession().setAttribute("cognitoUser", newUserAdd);

        WeatherApiDao wDao = new WeatherApiDao();
        Weather currentWeather = wDao.getWeather(newUserAdd.getLonLat());
        request.getSession().setAttribute("currentWeather", currentWeather);


        String url = "/index.jsp";

        //testing sc / el
        request.setAttribute("url", url);
        //response.sendRedirect(request.getContextPath()+url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    public void init() throws ServletException {

    }

    /**
     * this method take a zip code and
     * returns a location.  the location
     * is saved in the HPP user table
     *
     * @param zipcode
     * @return
     * @throws JsonProcessingException
     */
    private String getLocation(int zipcode) throws JsonProcessingException {
        ZipApiDao zDAO = new ZipApiDao();

        //first call sets object up for 2nd call
        zDAO.getCityState(zipcode);
        String location = zDAO.getLongLatt();

        return location;
    }


}