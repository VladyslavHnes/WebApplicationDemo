package controller.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by vlad on 25.10.16.
 */
public class LoginRedirectStudentController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        response.sendRedirect("LogInStudentPage.jsp");
    }
}
