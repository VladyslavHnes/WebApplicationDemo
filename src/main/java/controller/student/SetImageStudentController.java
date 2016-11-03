package controller.student;

import dao.requests.DAOSetImageURL;
import model.Student;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String imageURL = request.getParameter("imageURL");
        System.out.println(imageURL);
        Student student = new Student();
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        try {
            DAOSetImageURL.setImageURL("students",imageURL,firstName,lastName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(imageURL);
        session.setAttribute("imageURL",imageURL);
        response.sendRedirect("StudentProfilePage.jsp");
    }
}
