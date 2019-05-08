package by.bntu.fitr.povt.bahirauruslan.facultative.controllers.actions;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ActionFactory {
    private static final Map<String, Action> actions = null;

    public static Action getAction(HttpServletRequest request)
    {
        String key = (request.getServletPath() != null
                && request.getServletPath().length() > 1)
                ? request.getMethod() + request.getServletPath().substring(1) : request.getMethod();
        return actions.get(key);
    }
}
