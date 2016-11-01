package controller.student;

import dao.requests.DAOSetSubject;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by vlad on 26.10.16.
 */
public class SubscribeStudentController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,java.io.IOException{
        String[] subscribedCourses = request.getParameterValues("subscribeBox");
        HttpSession session = request.getSession(true);
        if(subscribedCourses == null) {
            session.setAttribute("isFirst", false);
            response.sendRedirect("SubscribeCoursePage.jsp");
        }
        else {
            Student student = (Student) session.getAttribute("student");
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            for (String subject: subscribedCourses) {
                try {
                    DAOSetSubject.setSubject(subject, firstName, lastName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
