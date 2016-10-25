package controller;

import dao.DAOLogin;
import model.Student;
import model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            if (teacher != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",teacher);
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
