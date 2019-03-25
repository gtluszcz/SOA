package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "NotLogedIn Filter", urlPatterns = {"/book.jsp","/book"})
public class NotLogedInFilter extends HttpFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (session.getAttribute("isSignedIn") == null || (!((boolean) session.getAttribute("isSignedIn")))) {
            resp.setStatus(403);
            resp.sendRedirect("/index.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }
}
