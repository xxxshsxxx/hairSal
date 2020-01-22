package servlet;

import manager.ApointmentManager;
import manager.GalleryManager;
import model.Apointment;
import model.Gallery;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(urlPatterns = "/addGallery")
@MultipartConfig
public class AddGalleryManager extends HttpServlet {
    private GalleryManager galleryManager = new GalleryManager();
    private ApointmentManager apointmentManager = new ApointmentManager();
    private static final String IMAGE_UPLOAD_DIR = "D:\\Java\\projects\\Hairsal\\web\\img\\gallery\\";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        String description = req.getParameter("description");

        Part filePart = req.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        fileName = System.currentTimeMillis() + "_" + System.nanoTime() + fileName;
        filePart.write(IMAGE_UPLOAD_DIR + fileName);

        try {
            Gallery gallery = Gallery.builder()
                    .picUrl(fileName)
                    .date(sdf.parse(date))
                    .description(description)
                    .build();
            galleryManager.add(gallery);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Apointment> apointments = apointmentManager.getAllApointments();
        req.setAttribute("apointment", apointments);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}

