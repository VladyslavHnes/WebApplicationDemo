package controller.teacher;

import dao.hibernate.DAOHibernateStudent;
import dao.hibernate.DAOHibernateTeacher;
import dao.jdbc.DAOGetMark;
import dao.jdbc.DAOGetStudents;
import dao.jdbc.DAOLogin;
import model.Course;
import model.Student;
import model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 25.10.16.
 */
public class LogInTeacherController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        DAOHibernateTeacher daoHibernateTeacher = new DAOHibernateTeacher();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Teacher teacher = daoHibernateTeacher.login(login, password);
        HttpSession session = request.getSession(true);
        if (teacher != null) {
            String imageURL = teacher.getImageURL();
            System.out.println(imageURL);
            session.setAttribute("imageURL",imageURL);
            String subject = teacher.getSubject();
            session.setAttribute("subject",subject);
            List<Course> studentsInfoList = (List<Course>) daoHibernateTeacher.getStudents(subject);
            //List of objects that have info about a certain student in a certain subject
            ArrayList<Integer> marks = new ArrayList<>();
            for (int i = 0;i < studentsInfoList.size();i++){
                marks.add(i,studentsInfoList.get(i).getMark());
            }
            session.setAttribute("marks", marks);
            session.setAttribute("students",studentsInfoList);
            session.setAttribute("teacher",teacher);
            response.sendRedirect("TeacherProfilePage.jsp"); //logged-in page
        }
        else {
            session.setAttribute("wrongLoginOrPassword",false);
            response.sendRedirect("LogInTeacherPage.jsp");
        }
    }
}
