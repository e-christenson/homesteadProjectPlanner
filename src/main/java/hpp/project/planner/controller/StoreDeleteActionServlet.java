package hpp.project.planner.controller;


import hpp.project.planner.entity.Project;
import hpp.project.planner.entity.Store;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Homestead Project Planer
 * add user servlet
 *
 * @author EChristenson
 */
@WebServlet(
        name = "HPPdeleteStore",
        urlPatterns = {"/HPPdeleteStore"}
)
public class StoreDeleteActionServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao sDao = new GenericDao(Store.class);




    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        int Id = Integer.parseInt(request.getParameter("Id"));
        Store store = (Store) sDao.getById(Id);
        //user can have a stale page on browser, so if we come into this
        //servlet w/o session data we skip the delete and go to login screen
        if (store != null){

            sDao.delete(store);
        }





        String url = "/storeList";
        request.setAttribute("url", url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }



    public void init() throws ServletException {

    }





}