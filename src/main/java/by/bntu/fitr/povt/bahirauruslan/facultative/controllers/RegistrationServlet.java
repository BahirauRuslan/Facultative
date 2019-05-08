package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcPermissionDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.AccountService;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.registration.RegistrationResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class RegistrationServlet extends HttpServlet {
    private AccountService service = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password2");
        RegistrationResult result = service.registration(login, password, passwordRepeat, fullName);
        response.sendRedirect("/Facultative");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
