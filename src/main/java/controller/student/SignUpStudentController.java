package controller.student;

import dao.jdbc.DAORegistry;
import dao.jdbc.DAOShowCourses;
import model.Course;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by vlad on 26.10.16.
 */
public class SignUpStudentController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        Student student = new Student();
        student.setLogin(login);
        student.setPassword(password);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        List<Course> courses = DAOShowCourses.getCourses();
        HttpSession session = request.getSession(true);
        session.setAttribute("courses",courses);
        boolean flag = DAORegistry.regStudent(student.getFirstName(),student.getLastName(),
                student.getLogin(),student.getPassword());
        if (flag) {
            session.setAttribute("student",student);
            response.sendRedirect("SubscribeCoursePage.jsp"); //logged-in page
        }
        else {
            response.sendRedirect("UserAlreadyExists.jsp"); //error page
        }
    }
}
