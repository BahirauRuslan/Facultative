package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcPermissionDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Permission;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProbeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = new JdbcPermissionDao().getAll().get(0).getName();
        request.setAttribute("permiss", name);
        request.getRequestDispatcher("/probe.jsp").forward(request, response);
    }
}
