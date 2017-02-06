package controller.student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.hibernate.DAOHibernateStudent;
import dao.jdbc.DAOGetMark;
import dao.jdbc.DAOShowCourses;
import model.Course;
import model.CourseInfoEntity;
import model.Student;

import java.util.*;

/**
 * Created by vlad on 19.09.2016.
 */
public class LogInStudentController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException, NullPointerException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DAOHibernateStudent hibernateStudent = new DAOHibernateStudent();
        Student student = hibernateStudent.login(login, password);

        List<CourseInfoEntity> courses = hibernateStudent.getCoursesInfo();
        HttpSession session = request.getSession(true);
        session.setAttribute("courses", courses);
        if (student != null) {
            String imageURL = student.getImageURL();
            session.setAttribute("imageURL", imageURL);
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            ArrayList<Integer> marks = new ArrayList<>();
            int javaMark = hibernateStudent.getMark("Java", firstName, lastName);
            marks.add(javaMark);
            int javaScriptMark = hibernateStudent.getMark("JavaScript", firstName, lastName);
            marks.add(javaScriptMark);
            int dataStructuresMark = hibernateStudent.getMark("DataStructures", firstName, lastName);
            marks.add(dataStructuresMark);
            session.setAttribute("marks", marks);
            session.setAttribute("student", student);
            response.sendRedirect("StudentProfilePage.jsp"); //logged-in page
        } else {
            session.setAttribute("wrongLoginOrPassword", false);
            response.sendRedirect("LogInStudentPage.jsp");
        }
    }
}

