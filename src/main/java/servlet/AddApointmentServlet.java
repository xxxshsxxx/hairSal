package servlet;

import manager.ApointmentManager;
import model.Apointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/addApointment")
public class AddApointmentServlet extends HttpServlet {
    private ApointmentManager apointmentManager = new ApointmentManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String phone = req.getParameter("phone");
        String serviseID = req.getParameter("serviseID");
        String masterID = req.getParameter("masterID");
        String note = req.getParameter("note");
        try {
            Apointment apointment = Apointment.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .date(sdf.parse(date))
                    .time(time)
                    .phone(phone)
                    .serviceId(Integer.parseInt(serviseID))
                    .masterId(Integer.parseInt(masterID))
                    .notes(note)
                    .build();
            apointmentManager.add(apointment);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
