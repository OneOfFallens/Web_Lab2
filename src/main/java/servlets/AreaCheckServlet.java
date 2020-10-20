package servlets;

import beans.MyBean;
import beans.TableRow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.System.nanoTime;

@WebServlet(name = "AreaCheckServlet", urlPatterns = "/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MyBean bean = (MyBean) req.getSession().getAttribute("results");
            req.getSession().setAttribute("results", bean);
            long startTime = nanoTime();
            String time = new Date().toString();
            int x = Integer.parseInt(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            double r = Double.parseDouble(req.getParameter("r"));
            if (checkValues(x, y, r)) {
                String answer;
                if (validate(x, y, r)) {
                    answer = "<span style='color: #439400'>Попала</span>";
                }
                else{
                    answer = "<span style='color: #94002D'>Не попала</span>";
                }
                long endTime = nanoTime();
                String workTime = (endTime - startTime)/100000000 + "." + (endTime - startTime)%100000000;
                bean.addRow(new TableRow(x,y,r,answer,time,workTime));
                System.out.println(bean.getTableRows().size());
                System.out.println(bean.getTableRows().get(bean.getTableRows().size() - 1).toString());
                req.getSession().setAttribute("results", bean);
                req.getRequestDispatcher("answer.jsp").forward(req, resp);
            }
            else{
                resp.sendError(400);
            }
        }
        catch(NumberFormatException e){
            resp.sendError(400);
        }
    }

    private boolean validate(int x, double y, double r){
        if (x>=0 && y>=0){
            return(x*x+y*y < r*r/4);
        }
        else if (x>=0 && y<= 0){
            return((x < r)&&(x> -r));
        }
        else if (x<0 && y>0){
            return(y<x+1);
        }
        else{
            return false;
        }
    }
    private boolean checkValues(int x, double y, double r) {
        return Arrays.asList(-4, -3, -2, -1, 0, 1, 2, 3, 4).contains(x) &&
                (y <= 3 && y >= -5) &&
                Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0).contains(r);
    }
}
