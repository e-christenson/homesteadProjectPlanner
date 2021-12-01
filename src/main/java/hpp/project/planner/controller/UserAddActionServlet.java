package hpp.project.planner.controller;


import hpp.project.planner.entity.User;
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
        name = "HPPaddUser",
        urlPatterns = { "/HPPaddUser" }
)
public class UserAddActionServlet extends HttpServlet {

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



    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //info in from web form
        String  name = request.getParameter("name");
        String  email = request.getParameter("email");
        String  password = request.getParameter("password");
        int  zip_code = Integer.parseInt(request.getParameter("zip_code"));

        User newUserAdd = new User(0,name,email,password,zip_code);

        UserDao dao = new UserDao();
        int id = dao.insert(newUserAdd);

        List<User> users = dao.getAll();
        request.setAttribute("users",users);

        logger.info("DAO GETALL RETURNS===== "+dao.getAll());


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