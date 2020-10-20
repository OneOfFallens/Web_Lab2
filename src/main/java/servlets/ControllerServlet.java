package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((req.getParameter("x")!= null) && (req.getParameter("y") != null) && (req.getParameter("r")!=null)){
            getServletContext().getRequestDispatcher("/areaCheck").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
