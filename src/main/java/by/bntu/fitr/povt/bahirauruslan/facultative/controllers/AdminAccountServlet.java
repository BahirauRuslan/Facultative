package by.bntu.fitr.povt.bahirauruslan.facultative.controllers;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.admin.AccountService;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminAccountServlet")
public class AdminAccountServlet extends HttpServlet {
    private AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("do_logout") != null)
        {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/Facultative");
        }

        if (request.getParameter("sumbitChanges") != null && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            Account account = accountService.getAccount(id);
            String permission = request.getParameter("permission");
            boolean isAvailable = request.getParameter("isAvailable") != null;
            accountService.updateAccount(account, isAvailable, permission);
            response.sendRedirect("/Facultative/admin/accounts");
        } else if (request.getParameter("deleteAccount") != null && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            Account account = accountService.getAccount(id);
            accountService.deleteAccount(account);
            response.sendRedirect("/Facultative/admin/accounts");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id").toString());
            request.setAttribute("account", accountService.getAccount(id));
            request.getRequestDispatcher("/admin/account.jsp").forward(request, response);
        }
    }
}
