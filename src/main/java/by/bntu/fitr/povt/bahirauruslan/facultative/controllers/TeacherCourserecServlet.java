package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.teacher.CourseRecordService;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.teacher.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "TeacherCourserecServlet")
public class TeacherCourserecServlet extends HttpServlet {
    private CourseRecordService courseRecordService = new CourseRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }

        if (request.getParameter("sumbitChanges") != null && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            CourseRecord courseRecord = courseRecordService.getCourseRecord(id);
            int mark = Integer.parseInt(request.getParameter("mark"));
            String review = request.getParameter("review");
            courseRecord.setDate(new java.sql.Date(new java.util.Date().getTime()));
            courseRecordService.setReviewAndMark(courseRecord, mark, review);
            response.sendRedirect("/Facultative/teacher/courses");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            CourseRecord courseRecord = courseRecordService.getCourseRecord(id);
            request.setAttribute("courseRecord", courseRecord);
            request.getRequestDispatcher("/teacher/courserec.jsp").forward(request, response);
        }
    }
}
