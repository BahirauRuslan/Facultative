package by.bntu.fitr.povt.bahirauruslan.facultative.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class View {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public View(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void navigate() throws ServletException, IOException {
        String path = (request.getServletPath() != null
                && request.getServletPath().length() > 1)
                ? request.getServletPath().substring(1) + ".jsp" : "index.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }
}
