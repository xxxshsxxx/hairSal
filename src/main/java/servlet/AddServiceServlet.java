package servlet;

import manager.ApointmentManager;
import manager.ServiceManager;
import model.Apointment;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns = "/addService")
@MultipartConfig
public class AddServiceServlet extends HttpServlet {
private ServiceManager serviceManager = new ServiceManager();
    private ApointmentManager apointmentManager = new ApointmentManager();
    private static final String IMAGE_UPLOAD_DIR = "D:\\Java\\projects\\Hairsal\\web\\img\\service\\";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        Part filePart = req.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        fileName = System.currentTimeMillis() + "_" +System.nanoTime() + fileName;
        filePart.write(IMAGE_UPLOAD_DIR + fileName);

        Service service = Service.builder()
                .name(name)
                .description(description)
                .price(Double.parseDouble(price))
                .imagePath(fileName)
                .build();
        serviceManager.add(service);

        List<Apointment> apointments = apointmentManager.getAllApointments();
        req.setAttribute("apointment", apointments);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}
