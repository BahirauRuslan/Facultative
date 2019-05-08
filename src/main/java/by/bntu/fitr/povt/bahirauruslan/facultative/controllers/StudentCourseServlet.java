package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.student.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentCourseServlet")
public class StudentCourseServlet extends HttpServlet {
    private CourseRecordService courseRecordService = new CourseRecordService();
    private CourseService courseService = new CourseService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }

        if (request.getParameter("subscribe") != null && request.getParameter("id") != null) {
            Account student = (Account)request.getSession().getAttribute("user");
            int id = Integer.parseInt(request.getParameter("id").toString());
            Course course = courseService.getCourse(id);
            courseRecordService.subscribeToCourses(student, course);
            response.sendRedirect("/Facultative/student/courses");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            Course course = courseService.getCourse(id);
            request.setAttribute("course", course);
            request.getRequestDispatcher("/student/course.jsp").forward(request, response);
        }
    }
}
