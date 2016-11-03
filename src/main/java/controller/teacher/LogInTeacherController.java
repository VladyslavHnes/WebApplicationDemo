package controller.teacher;

import dao.requests.DAOGetMark;
import dao.requests.DAOGetStudents;
import dao.requests.DAOLogin;
import dao.requests.DAOShowCourses;
import model.Course;
import model.Student;
import model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by vlad on 25.10.16.
 */
public class LogInTeacherController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Teacher teacher = DAOLogin.teacherRequest(login, password);
            HttpSession session = request.getSession(true);

            if (teacher != null) {
                String imageURL = teacher.getImageURL();
                System.out.println(imageURL);
                session.setAttribute("imageURL",imageURL);
                String subject = teacher.getSubject();
                session.setAttribute("subject",subject);
                ArrayList<Student> students = DAOGetStudents.getStudents(subject);
                ArrayList<Integer> marks = DAOGetMark.getMarks(subject);
                session.setAttribute("marks", marks);
                session.setAttribute("students",students);
                session.setAttribute("teacher",teacher);
                response.sendRedirect("TeacherProfilePage.jsp"); //logged-in page
            }
            else {
                session.setAttribute("wrongLoginOrPassword",false);
                response.sendRedirect("LogInTeacherPage.jsp");
            }
        }
        catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
