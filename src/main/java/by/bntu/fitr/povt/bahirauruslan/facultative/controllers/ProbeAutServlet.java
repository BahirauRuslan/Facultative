package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.AccountService;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.authentication.AuthenticationResult;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.registration.RegistrationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProbeAutServlet")
public class ProbeAutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AccountService service = new AccountService();
        AuthenticationResult result = service.authenticate(login, password);
        response.getWriter().println(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/probeaut.jsp").forward(request, response);
    }
}
