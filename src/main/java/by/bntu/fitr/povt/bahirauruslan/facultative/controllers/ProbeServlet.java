package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcPermissionDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Permission;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.AccountService;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.registration.RegistrationResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProbeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password2");
        AccountService service = new AccountService();
        RegistrationResult result = service.registration(login, password, passwordRepeat, fullName);
        response.getWriter().println(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = JdbcPermissionDao.getInstance().getAll().size() + " ";
        name += JdbcPermissionDao.getInstance().getAll().size() + " ";
        name += JdbcPermissionDao.getInstance().getAll().size() + " ";
        request.setAttribute("permiss", name);
        request.getRequestDispatcher("/probe.jsp").forward(request, response);
    }
}
