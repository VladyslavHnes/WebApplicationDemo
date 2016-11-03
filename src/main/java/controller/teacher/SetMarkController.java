package controller.teacher;

import com.sun.deploy.net.HttpRequest;
import dao.requests.DAOSetMark;
import model.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by vlad on 02.11.16.
 */
public class SetMarkController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("students");
        String subject = (String) session.getAttribute("subject");
        ArrayList<Integer> marksArray = new ArrayList<>();
        for(int i = 0;i < students.size();i++) {
            String firstName = students.get(i).getFirstName();
            String lastName = students.get(i).getLastName();
            try {
                Integer mark = Integer.parseInt(request.getParameter("mark" + i));
                if(mark > 100 | mark <= 0){
                    session.setAttribute("illegalValues",false);
                    response.sendRedirect("TeacherProfilePage.jsp");
                    return;
                }else {
                    try {
                        DAOSetMark.setMark(subject, mark, firstName, lastName);
                        marksArray.add(mark);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                if (!response.isCommitted()) {
                    session.setAttribute("illegalValues", false);
                    response.sendRedirect("TeacherProfilePage.jsp");
                    return;
                }
            }
        }
        session.setAttribute("marks",marksArray);
        if(!response.isCommitted()){
            response.sendRedirect("TeacherProfilePage.jsp");
        }
    }
}
