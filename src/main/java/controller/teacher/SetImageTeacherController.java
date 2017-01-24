package controller.teacher;

import dao.jdbc.DAOSetImageURL;
import model.Teacher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vlad on 03.11.16.
 */
public class SetImageTeacherController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String imageURL = request.getParameter("imageURL");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String firstName = teacher.getFirstName();
        String lastName = teacher.getLastName();
        DAOSetImageURL.setImageURL("teachers",imageURL,firstName,lastName);
        session.setAttribute("imageURL",imageURL);
        response.sendRedirect("TeacherProfilePage.jsp");
    }
}
