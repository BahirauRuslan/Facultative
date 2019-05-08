package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.admin.AccountService;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.admin.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminCourseServlet")
public class AdminCourseServlet extends HttpServlet {
    private AccountService accountService = new AccountService();
    private CourseService courseService = new CourseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }

        if (request.getParameter("sumbitChanges") != null && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            Course course = courseService.getCourse(id);
            String teacherLogin = request.getParameter("teacher");
            Account teacher = accountService.findTeacher(teacherLogin);
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            courseService.updateCourse(course, teacher, name, description);
            response.sendRedirect("/Facultative/admin/courses");
        } else if (request.getParameter("deleteCourse") != null && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            Course course = courseService.getCourse(id);
            courseService.deleteCourse(course);
            response.sendRedirect("/Facultative/admin/courses");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            request.setAttribute("course", courseService.getCourse(id));
            request.setAttribute("teachers", accountService.getAllTeachers());
            request.getRequestDispatcher("/admin/course.jsp").forward(request, response);
        }
    }
}
