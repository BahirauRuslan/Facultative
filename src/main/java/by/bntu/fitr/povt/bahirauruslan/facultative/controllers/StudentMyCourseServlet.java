package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.student.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentMyCourseServlet")
public class StudentMyCourseServlet extends HttpServlet {
    private CourseRecordService courseRecordService = new CourseRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Account student = (Account)request.getSession().getAttribute("user");
            int id = Integer.parseInt(request.getParameter("id").toString());
            CourseRecord courseRecord = courseRecordService.getCourseRecord(id);
            request.setAttribute("courseRecord", courseRecord);
            request.setAttribute("current", courseRecordService.getCurrentCoursesCount(student));
            request.setAttribute("completed", courseRecordService.getOldCoursesCount(student));
            request.getRequestDispatcher("/student/mycourse.jsp").forward(request, response);
        }
    }
}
