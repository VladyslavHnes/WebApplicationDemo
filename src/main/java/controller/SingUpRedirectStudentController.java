package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vlad on 26.10.16.
 */
public class SingUpRedirectStudentController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        try {
            System.out.println("S");
            response.sendRedirect("SignUpStudentPage.jsp"); //signed-up page
        }
        catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}
