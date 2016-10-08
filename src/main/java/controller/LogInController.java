package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import model.Student;

/**
 * Created by vlad on 19.09.2016.
 */
public class LogInController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, java.io.IOException {

        try {
            Student student = new Student();
            student.setLogin(request.getParameter("login"));
            student.setPassword(request.getParameter("password"));
            //user = UserDAO.login(user);
            if (student != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",student); 
                response.sendRedirect("userLogged.jsp"); //logged-in page
            }
            else
                response.sendRedirect("userLogged.jsp"); //error page
        }
        catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}

