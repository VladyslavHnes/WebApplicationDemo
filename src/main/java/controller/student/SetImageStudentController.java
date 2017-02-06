package controller.student;

import dao.hibernate.DAOHibernateStudent;
import dao.jdbc.DAOSetImageURL;
import model.Student;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vlad on 03.11.16.
 */
public class SetImageStudentController extends HttpServlet {
    private static Logger logger = Logger.getLogger(SetImageStudentController.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        DAOHibernateStudent hibernateStudent = new DAOHibernateStudent();
        String imageURL = request.getParameter("imageURL");
        Student student = (Student) session.getAttribute("student");
        String login = student.getLogin();
        hibernateStudent.setImageURL(imageURL,login);
        session.setAttribute("imageURL",imageURL);
        response.sendRedirect("StudentProfilePage.jsp");
    }
}
