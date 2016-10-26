package controller.student;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by vlad on 26.10.16.
 */
public class SubscribeStudentController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException{
        try {
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Student student = new Student();
            student.setLastName(lastName);
            student.setFirstName(firstName);
            student.setLogin(login);
            student.setPassword(password);
            HttpSession session = request.getSession(true);
            session.setAttribute("student", student);

        }
        catch (Throwable theException) {
            System.out.println(theException);
        }


    }


}
