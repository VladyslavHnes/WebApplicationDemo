package controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOLogin;
import model.Student;

/**
 * Created by vlad on 19.09.2016.
 */
public class LogInStudentController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Student student = DAOLogin.studentRequest(login, password);
            if (student != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",student); 
                response.sendRedirect("userLogged.jsp"); //logged-in page
            }
            else
                response.sendRedirect("ErrorPage.jsp"); //error page
        }
        catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}

