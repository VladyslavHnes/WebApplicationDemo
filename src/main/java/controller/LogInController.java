package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by vlad on 19.09.2016.
 */
public class LogInController extends HttpServlet {
    String login;
    String password;

    public static void main(String [] args){
        LogInController logInController = new LogInController();
        while (true){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        login = (String)request.getAttribute("login");
        session.setAttribute("login", login);
        password = (String)request.getAttribute("password");
        session.setAttribute("password", password);
        System.out.println(login);
    }
}
