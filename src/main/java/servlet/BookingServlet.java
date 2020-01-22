package servlet;

import manager.MasterManager;
import manager.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/booking")
public class BookingServlet extends HttpServlet {
    ServiceManager serviceManager = new ServiceManager();
    MasterManager masterManager = new MasterManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("service", serviceManager.getAllService());
        req.setAttribute("masters", masterManager.getAllMasters());
        req.getRequestDispatcher("/WEB-INF/booking.jsp").forward(req,resp);

    }
}
