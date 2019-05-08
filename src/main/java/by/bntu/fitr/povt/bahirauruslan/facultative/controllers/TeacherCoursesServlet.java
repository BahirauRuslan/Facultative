package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.teacher.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TeacherCoursesServlet")
public class TeacherCoursesServlet extends HttpServlet {
    private CourseService courseService = new CourseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account teacher = (Account)request.getSession().getAttribute("user");
        request.setAttribute("courses", courseService.getAllCourses(teacher));
        request.getRequestDispatcher("/teacher/courses.jsp").forward(request, response);
    }
}
