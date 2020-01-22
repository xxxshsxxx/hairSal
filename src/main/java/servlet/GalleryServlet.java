package servlet;

import manager.GalleryManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/gallery")
public class GalleryServlet extends HttpServlet {
    GalleryManager galleryManager = new GalleryManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.setAttribute("gallery", galleryManager.getAllPic());
        req.getRequestDispatcher("gallery.jsp").forward(req,resp);
    }
}
