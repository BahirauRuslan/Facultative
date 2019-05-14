package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontServlet")
public class FrontServlet extends HttpServlet {
    private AccountService service = new AccountService();
    private CourseService courseService = new CourseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        service.authorization(request.getSession(), login, password, "user");
        if (request.getParameter("do_logout") != null)
        {
            request.getSession().removeAttribute("user");
        }
        if (request.getSession().getAttribute("user") == null)
        {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (((Account)request.getSession().getAttribute("user")).getPermission().getName().equals("Admin")) {
            response.sendRedirect("/Facultative/admin/accounts");
        } else if (((Account)request.getSession().getAttribute("user")).getPermission().getName().equals("Teacher")) {
            response.sendRedirect("/Facultative/teacher/courses");
        } else if (((Account)request.getSession().getAttribute("user")).getPermission().getName().equals("Student")) {
            response.sendRedirect("/Facultative/student/courses");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("courses", courseService.getAllCourses());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //View view = new View(request, response);
        //Action action = ActionFactory.getAction(request);
        //action.execute(view);
        //view.navigate();
        //request.setAttribute("method", request.getServletPath());
        //System.out.println(request.getServletPath() + "12345qwerty");
        //request.getRequestDispatcher("/index.jsp").forward(request, response);
    }*/
}
