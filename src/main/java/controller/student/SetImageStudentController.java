package controller.student;

import dao.requests.DAOSetImageURL;
import model.Student;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vlad on 03.11.16.
 */
public class SetImageStudentController extends HttpServlet {
    private static Logger logger = Logger.getLogger(SetImageStudentController.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String imageURL = request.getParameter("imageURL");
        Student student = (Student) session.getAttribute("student");
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        DAOSetImageURL.setImageURL("students",imageURL,firstName,lastName);
        session.setAttribute("imageURL",imageURL);
        response.sendRedirect("StudentProfilePage.jsp");
    }
}
