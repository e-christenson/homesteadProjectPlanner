package hpp.project.planner.controller;

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
 * this servlet loads a users store list into a session object
 *
 * @author EChristenson
 */
@WebServlet(
        name = "storeList",
        urlPatterns = {"/storeList"}
)
public class StoreListDisplay extends HttpServlet {


    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();
        User cognitoUser = (User) ses.getAttribute("cognitoUser");
        GenericDao sDao = new GenericDao(Store.class);

        if (cognitoUser != null) {

            List<Store> storeL = sDao.findByPropertyEqual("user_id", cognitoUser.getId());

            request.setAttribute("storeList", storeL);
        }


        String url = "/storeList.jsp";


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    public void init() throws ServletException {


    }


}
