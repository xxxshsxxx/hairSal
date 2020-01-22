package servlet;

import manager.ServiceManager;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    ServiceManager serviceManager = new ServiceManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> services = serviceManager.getAllService();
        req.setAttribute("services", services);


        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
