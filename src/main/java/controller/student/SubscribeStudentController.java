package controller.student;

import dao.requests.DAOGetMark;
import dao.requests.DAOLogin;
import dao.requests.DAOSetSubject;
import dao.requests.DAOShowCourses;
import model.Course;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

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
            ArrayList<Course> courses = DAOShowCourses.getCourses();
            session.setAttribute("courses",courses);
            try {
                student = DAOLogin.studentRequest((String)session.getAttribute("login"),
                        (String)session.getAttribute("password"));
                ArrayList<Integer> marks = new ArrayList<>();
                int javaMark = DAOGetMark.getMark("Java",firstName,lastName);
                marks.add(javaMark);
                int javaScriptMark = DAOGetMark.getMark("JavaScript",firstName,lastName);
                marks.add(javaScriptMark);
                int dataStructuresMark = DAOGetMark.getMark("DataStructures",firstName,lastName);
                marks.add(dataStructuresMark);
                session.setAttribute("marks",marks);
                session.setAttribute("student",student);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (String subject: subscribedCourses) {
                try {
                    DAOSetSubject.setSubject(subject, firstName, lastName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(!response.isCommitted()) {
                response.sendRedirect("StudentProfilePage.jsp");
            }
        }

    }


}
