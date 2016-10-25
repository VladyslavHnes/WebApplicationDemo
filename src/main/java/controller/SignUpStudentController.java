package controller;

import dao.DAOLogin;
import dao.DAORegistry;
import model.Student;
import model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by vlad on 26.10.16.
 */
public class SignUpStudentController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            HttpSession session = request.getSession(true);
            boolean flag = DAORegistry.regStudent(lastname, firstname,login,password);
            if (flag) {
                response.sendRedirect("userLogged.jsp"); //logged-in page
            }
            else
                response.sendRedirect("UserAlreadyExist.jsp"); //error page
        }
        catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
