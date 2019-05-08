package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.teacher.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TeacherCourseServlet")
public class TeacherCourseServlet extends HttpServlet {
    private CourseService courseService = new CourseService();
    private CourseRecordService courseRecordService = new CourseRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            Course course = courseService.getCourse(id);
            request.setAttribute("course", course);
            request.setAttribute("courseRecords", courseRecordService.getCourseRecords(course));
            request.getRequestDispatcher("/teacher/course.jsp").forward(request, response);
        }
    }
}
