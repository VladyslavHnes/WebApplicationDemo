package controller.student;

import dao.requests.DAOShowCourses;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            for (String s: subscribedCourses)
                System.out.println(s);
        }


    }


}
