package servlet;

import manager.ApointmentManager;
import model.Apointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
ApointmentManager apointmentManager = new ApointmentManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "admin";
        String password = "admin";


        if (req.getParameter("login").equals(username) && req.getParameter("password").equals(password)){
            List<Apointment> apointments = apointmentManager.getAllApointments();
            req.setAttribute("apointment", apointments);
            req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/home");
        }

    }
}
