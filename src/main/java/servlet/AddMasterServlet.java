package servlet;

import manager.ApointmentManager;
import manager.MasterManager;
import model.Apointment;
import model.Master;

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

@WebServlet(urlPatterns = "/addMaster")
@MultipartConfig
public class AddMasterServlet extends HttpServlet {
    private MasterManager masterManager = new MasterManager();
    private ApointmentManager apointmentManager = new ApointmentManager();
    private static final String IMAGE_UPLOAD_DIR = "D:\\Java\\projects\\Hairsal\\web\\img\\master\\";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        Part filePart = req.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        fileName = System.currentTimeMillis() + "_" +System.nanoTime() + fileName;
        filePart.write(IMAGE_UPLOAD_DIR + fileName);

        Master master = Master.builder()
                .name(name)
                .surname(surname)
                .imagePath(fileName)
                .build();
        masterManager.add(master);


        List<Apointment> apointments = apointmentManager.getAllApointments();
        req.setAttribute("apointment", apointments);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}

